package inf112.skeleton.app;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.skeleton.app.network.NetworkHandler;
import inf112.skeleton.app.network.Packets.*;
import inf112.skeleton.app.network.Packets.Events.MoveEvent;
import inf112.skeleton.app.network.Packets.Events.RotationEvent;
import inf112.skeleton.app.network.Packets.Initialize.CardsPacket;
import inf112.skeleton.app.network.Packets.Initialize.PlayerList;
import inf112.skeleton.app.object.Player;

import java.io.IOException;
import java.util.*;

public class GameServer extends Listener{

    public NetworkHandler network = new NetworkHandler();
    public Server server;
    public int numplayers;
    public PlayerList spillerliste = new PlayerList();
    public HashMap<Integer, Player> playerlist = new HashMap<>();
    public int recievedRegisters;

    public GameServer() {
        server = new Server();
        numplayers = 0;
        recievedRegisters = 0;

        System.out.println("Server started");
        server.start();
        network.register(server);

        try {
            server.bind(network.PORT, network.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }


        server.addListener(this);
    }
        public void connected(Connection c) {
                System.out.println("Recieved a connection from " + c.getRemoteAddressTCP().getHostString());
                numplayers++;
                Player newPlayer = new Player(c.getID());
                playerlist.put(c.getID(), newPlayer);
                spillerliste.spillerliste.add(newPlayer);

                server.sendToAllTCP(spillerliste);

                Scanner sc = new Scanner(System.in);
                System.out.println("Start? y/n");
                if(sc.nextLine().equals("y")) {
                    server.sendToAllTCP(new CardsPacket());
                }

                System.out.println("Currently Connected players: " + playerlist.size());

    }

    public void received (Connection c, Object object) {
        if(object instanceof MoveEvent) {
            MoveEvent event = (MoveEvent)object;
            server.sendToAllExceptTCP(c.getID(), event);
        }
        if (object instanceof RotationEvent) {
            RotationEvent event = (RotationEvent)object;
            server.sendToAllExceptTCP(c.getID(), event);
        }
        if( object instanceof PlayerCards) {
            recievedRegisters++;
            playerlist.get(c.getID()).lockedHand = ((PlayerCards) object).kort;
            System.out.println("Lockedhand motatt");
            System.out.println(c.getID());

            if(recievedRegisters == playerlist.size()) {
                gameloop();
                server.sendToAllTCP(new CardsPacket());
                recievedRegisters = 0;
            }
        }
    }

    public void gameloop() {

        for(int i = 0 ; i < 5 ; i ++) {
            int finalI = i;
            PriorityQueue<Player> spillere = new PriorityQueue<Player>(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return Integer.compare(o1.lockedHand.get(finalI).priority, o2.lockedHand.get(finalI).priority);
                }
            });
            spillere.addAll(playerlist.values());

            for(Player p : spillere) {
                PlayingCardPair kortet = p.lockedHand.get(i);

                if(kortet.move >= (-1) && kortet.move < 90) {
                    MoveEvent event = new MoveEvent(p.id, kortet.move);
                    server.sendToAllTCP(event);
                } else {
                    RotationEvent event = new RotationEvent(p.id, kortet.move);
                    server.sendToAllTCP(event);
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    public void sendNewCards(CardsPacket cards) {
        server.sendToAllTCP(cards);
    }

    public static void main(String[] args) {

       GameServer server = new GameServer();

       Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
       cfg.setTitle("Server Running");
       cfg.setWindowedMode(500, 100);
       new Lwjgl3Application(new Game() {
           @Override
           public void create() {
                }
           }, cfg);

    }


}
