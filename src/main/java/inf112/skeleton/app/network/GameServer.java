package inf112.skeleton.app.network;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.skeleton.app.cards.PlayingCard;
import inf112.skeleton.app.network.Packets.*;
import inf112.skeleton.app.object.Player;
import inf112.skeleton.app.object.Robot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameServer{

    public NetworkHandler network = new NetworkHandler();
    public Server server;
    public int numplayers;
    public PlayerList spillerliste = new PlayerList();
    public HashMap<Integer, Player> playerlist = new HashMap<>();


    public GameServer(){
        server = new Server();
        numplayers = 0;

        System.out.println("Server started");

        network.register(server);

        try {
            server.bind(network.PORT, network.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }


        server.addListener(new Listener(){
            public void connected(Connection c) {
                System.out.println("Recieved a connection from " + c.getRemoteAddressTCP().getHostString());
                numplayers++;
                if(numplayers == 1) {
                    Player newPlayer = new Player(2,2, c.getID());
                    playerlist.put(c.getID(), newPlayer);
                    spillerliste.spillerliste.add(newPlayer);
                } else if (numplayers == 2) {
                    Player newPlayer = new Player(4,4, c.getID());
                    playerlist.put(c.getID(), newPlayer);
                    spillerliste.spillerliste.add(newPlayer);
                }
                server.sendToAllTCP(spillerliste);

                Scanner sc = new Scanner(System.in);
                System.out.println("Ready to start? y/n");
                if(sc.nextLine().equals("y")) {
                    sendCards(new CardsPacket());
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

            }
/*
            public void disconnected(Connection c) {
                System.out.println("Player disconnected from server");
            }

 */
        });

        server.start();




    }
    public void sendCards(CardsPacket cards) {
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
