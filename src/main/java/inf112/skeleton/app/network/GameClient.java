package inf112.skeleton.app.network;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.cards.PlayingCard;
import inf112.skeleton.app.network.Packets.*;
import inf112.skeleton.app.network.Packets.Events.ChangePhase;
import inf112.skeleton.app.network.Packets.Events.MoveEvent;
import inf112.skeleton.app.network.Packets.Events.PowerDown;
import inf112.skeleton.app.network.Packets.Events.RotationEvent;
import inf112.skeleton.app.network.Packets.Initialize.CardsPacket;
import inf112.skeleton.app.network.Packets.Initialize.PlayerList;
import inf112.skeleton.app.map.object.InputHandler;
import inf112.skeleton.app.map.object.Player;
import inf112.skeleton.app.map.object.Robot;

import java.io.IOException;

import java.util.ArrayList;


public class GameClient extends Listener {

    final Client client;
    final RoboRally game;
    ArrayList<Player> nySpillerListe;

    public GameClient(RoboRally game) {
        this.client = new Client();
        this.game = game;

        NetworkHandler.register(client);

        client.start();

        try {
            client.connect(5000, NetworkHandler.IPAddress, NetworkHandler.PORT, NetworkHandler.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        client.addListener(this);
    }

    public void connected(Connection connection) {

    }

    public void received(Connection c, Object object) {

        if (object instanceof PlayerList) {
            System.out.println(c.getID());
            System.out.println("ny spiller koblet til");
            PlayerList liste = (PlayerList) object;
            nySpillerListe = new ArrayList<>();
            for (Player robot : liste.spillerliste) {
                nySpillerListe.add(robot);
            }
            game.players = nySpillerListe;

            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                    game.robots = game.playerToRobot(game.players);
                    game.clientPlayer = game.robots.get(c.getID() - 1);
                        }
                    });
                }

        if(object instanceof CardsPacket) {
            CardsPacket packet = (CardsPacket)object;
            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                    game.handler = new InputHandler(game, game.clientPlayer);
                    game.deck.createDeck();
                    game.deck.dealOutCards(game.robots);
                    game.clientPlayer.playerCardstoHand(game.clientPlayer.getCards());
                }
            });
        }

        if(object instanceof MoveEvent) {
            MoveEvent event = (MoveEvent)object;

            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                    Robot robot = game.robots.get(event.id - 1);
                    robot.move(event.move);
                    System.out.println(robot.id + " flyttet seg " + event.move);
                }
            });
        }
        if(object instanceof RotationEvent) {
            RotationEvent event = (RotationEvent)object;
            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                    Robot robot = game.robots.get(event.id - 1);
                    robot.rotate(event.rotation);
                    System.out.println(robot.id + " roterte seg " + event.rotation);
                }
            });
        }

        if(object instanceof ChangePhase) {
            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                    game.phase = "check";
                }
            });
        }

        if(object instanceof PowerDown) {
            PowerDown robotid = (PowerDown)object;
            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                   Robot robot = game.robots.get(robotid.id);
                   robot.robotHealthPoint = 9;
                }
            });
        }


    }

    public void sendMove(MoveEvent move) {
        client.sendTCP(move);
    }

    public void sendRotation(RotationEvent rotation) {
        client.sendTCP(rotation);
    }

    public void sendCards(ArrayList<PlayingCard> playersLockedHand) {
        PlayerCards spillerskort = new PlayerCards();
        for(PlayingCard p : playersLockedHand) {
            PlayingCardPair kort = new PlayingCardPair(p.getMove(), p.priority);
            spillerskort.kort.add(kort);
        }
        client.sendTCP(spillerskort);

    }
    public void sendPowerDown(PowerDown robot) {
        client.sendTCP(robot);
    }



    public int getID() {
        return client.getID();
    }
}




