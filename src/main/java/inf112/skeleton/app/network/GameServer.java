package inf112.skeleton.app.network;


import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

public class GameServer{

    public NetworkHandler network = new NetworkHandler();
    public Server server;

    public GameServer(){
        server = new Server();


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

            }
            public void disconnected(Connection c) {
                System.out.println("Player disconnected from server");
            }
        });

        server.start();


    }

    public static void main(String[] args) {

       GameServer server = new GameServer();

    }


}
