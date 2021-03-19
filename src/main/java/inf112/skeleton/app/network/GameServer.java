package inf112.skeleton.app.network;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.skeleton.app.network.Packets.CreateRobot;
import inf112.skeleton.app.network.Packets.PlayerList;
import inf112.skeleton.app.object.Robot;

import java.io.IOException;

public class GameServer{

    public NetworkHandler network = new NetworkHandler();
    public Server server;
    public int numplayers;
    public PlayerList spillerliste = new PlayerList();

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
                System.out.println("Recieved a connection from" + c.getRemoteAddressTCP().getHostString());


                CreateRobot newRobot = new CreateRobot(2,2);
                server.sendToAllTCP(newRobot);


                /*
                Gdx.app.postRunnable(new Runnable() {

                    @Override
                    public void run() {
                        if(numplayers == 0) {
                            Robot spiller = new Robot(2, 2);
                            spillerliste.spillerliste.add(spiller);
                            numplayers++;
                        } else if (numplayers == 1) {
                            Robot spiller = new Robot(4, 4);
                            spillerliste.spillerliste.add(spiller);
                            numplayers++;
                        }

                        server.sendToAllTCP(spillerliste);
                    }
                });
*/

            }
            public void received (Connection c, Object object) {
                if(object instanceof Packet) {
                    System.out.println("motatt tilbake");
                }
            }

            public void disconnected(Connection c) {
                System.out.println("Player disconnected from server");
            }
        });

        server.start();


    }

    public static void main(String[] args) {

       GameServer server = new GameServer();

        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("CLOSE THIS WINDOW TO START THE TESTS");
        cfg.setWindowedMode(500, 100);
        new Lwjgl3Application(new Game() {
            @Override
            public void create() {
            }
        }, cfg);

    }


}
