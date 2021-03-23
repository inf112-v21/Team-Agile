package inf112.skeleton.app.network;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.math.Interpolation;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.examples.chat.Network;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.cards.PlayingCard;
import inf112.skeleton.app.network.Packets.*;
import inf112.skeleton.app.object.InputHandler;
import inf112.skeleton.app.object.Player;
import inf112.skeleton.app.object.Robot;

//import java.awt.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;

public class GameClient extends Listener {

    final Client client;
    String name;
    final RoboRally game;
    ArrayList<Player> nySpillerListe;
    InputHandler handler;
    public ArrayList<Robot> robotliste;
    Robot clientPlayer;

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
            System.out.println("spillerlliste motatt");
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
                        }
                    });


                }

        if(object instanceof CardsPacket) {
            CardsPacket packet = (CardsPacket)object;

            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                    game.handler = new InputHandler(game, game.robots.get(c.getID() - 1));
                    game.clientPlayer = game.robots.get(c.getID() - 1);
                    game.deck.dealCards(game.clientPlayer);
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
                    robot.move(event.toInt(event.move));
                }
            });
        }
        if(object instanceof RotationEvent) {
            RotationEvent event = (RotationEvent)object;
            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                    Robot robot = game.robots.get(event.id - 1);
                    robot.rotate(event.toInt(event.rotation));
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

        for(PlayingCard p : playersLockedHand) {

        }

    }

    public int getID() {
        return client.getID();
    }
}




