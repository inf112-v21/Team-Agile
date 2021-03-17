package inf112.skeleton.app.network;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.math.Interpolation;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.examples.chat.Network;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.network.Packets.PlayerList;

import java.awt.geom.Point2D;
import java.io.IOException;

public class GameClient {

    Client client;
    String name;
    RoboRally game;

    public GameClient(RoboRally game) {
        client = new Client();
        this.game = game;


        NetworkHandler.register(client);

        client.start();

        try {
            client.connect(5000, NetworkHandler.IPAddress, NetworkHandler.PORT,NetworkHandler.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }


        client.addListener(new Listener() {
            public void connected(Connection connection) {

            }
            public void received (Connection c, Object object) {

                if(object instanceof PlayerList) {
                    PlayerList list = (PlayerList)object;
                    game.players = list.spillerliste;

                    //client.sendTCP(test);

                }

            }

        });
    }


/*
    public static void main(String[] args) {

        GameClient client = new GameClient();

        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("test");
        cfg.setWindowedMode(1339,750);

        new Lwjgl3Application(new RoboRally(), cfg);

    }
*/

}
