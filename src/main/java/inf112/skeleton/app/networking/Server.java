package inf112.skeleton.app.networking;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;
import java.net.InetAddress;

public class Server {

    public Server() {
        Client client = new Client();
        InetAddress address = client.discoverHost(54777, 5000);

        //if there is no server you create it
        if (address == null) {
            //playerID = HelloWorld.playerids.get(0);
            //HelloWorld.playerids.remove(0);
            com.esotericsoftware.kryonet.Server server = new com.esotericsoftware.kryonet.Server();
            server.start();
            try {
                server.bind(54555, 54777);
            } catch (IOException e) {
                e.printStackTrace();

            }
            //skal ta imot forespørsler fra klienter til server
            server.addListener(new Listener() {
                public void received (Connection connection, Object object) {
                    if (object instanceof Request) {
                        Request request = (Request) object;
                        //System.out.println(player.keyUp(1));
                        Integer move = request.getMove();
                        Response response = new Response();
                        response.text = "Request to move received";
                        connection.sendTCP(response);
                    }
                }
            });
        }
        else {
            client.start();
            try {
                client.connect(5000, address, 54555, 54777);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
