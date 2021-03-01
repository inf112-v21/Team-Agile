package inf112.skeleton.app;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

public class Player extends InputAdapter {

    Vector2 position;
    TiledMapTileLayer playerLayer;

    int totalFlags = 3;
    int flagToTake = 1;
    private int playerID;

    ArrayList<FlagID> flagsvisited = new ArrayList<FlagID>();

    public Player(Vector2 playerpos, TiledMapTileLayer playerTileLayer) {
        this.position = playerpos;
        this.playerLayer = playerTileLayer;
        int totalFlags;
        int flagTotake;

        Client client = new Client();
        InetAddress address = client.discoverHost(54777, 5000);

        //if there is no server you create it
        if (address == null) {
            //playerID = HelloWorld.playerids.get(0);
            //HelloWorld.playerids.remove(0);
            Server server = new Server();
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




    private void move(int deltaX, int deltaY) {
        playerLayer.setCell((int) position.x, (int) position.y, null);
        position.set(position.x + deltaX, position.y + deltaY);

    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                move(-1, 0);
                break;
            case Input.Keys.RIGHT:
                move(1, 0);

                break;
            case Input.Keys.UP:
                move(0, 1);
                break;
            case Input.Keys.DOWN:
                move(0, -1);
                break;
        }
        return false;
    }



    public float getPositionX() {
        return position.x;
    }

    public float getPositionY() {
        return position.y;
    }

    public void visitFlag(int flagID) {
        if (flagID > flagToTake) {
            return;
        }
        if (flagID == flagToTake) {
            flagToTake += 1;
            System.out.println("flag:" + flagID + " was taken");
            System.out.println(flagToTake);
        }

    }
    public Integer getFlag() {

        return flagToTake;
    }

}