package inf112.skeleton.app.network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.skeleton.app.network.Packets.*;
import inf112.skeleton.app.network.Packets.Events.MoveEvent;
import inf112.skeleton.app.network.Packets.Events.PowerDown;
import inf112.skeleton.app.network.Packets.Events.RotationEvent;
import inf112.skeleton.app.network.Packets.Initialize.CardsPacket;
import inf112.skeleton.app.network.Packets.Initialize.PlayerList;
import inf112.skeleton.app.map.object.Player;

import java.io.IOException;
import java.util.*;

/**
 * GameServer klassen bruker biblioteket Kryonet til å
 * opprette en server instans, som bruker Listener fra
 * dette biblioteket til å lytte på tilkoblinger fra
 * klienter. Når det er oppstått en eller flere tilkoblinger
 * kan spillet startes, og derfra håndterer GameServer
 * sending og mottak av forskjellige typer pakker mellom
 * server og klienter, for sending og mottak av forskjellig
 * type informasjon om tilstander i spillet hos spillerne.
 *
 * @author Team Agile
 *
 */

public class GameServer extends Listener{

    public NetworkHandler network = new NetworkHandler();
    public Server server;
    public int numplayersconnected;
    public PlayerList spillerliste = new PlayerList();
    public HashMap<Integer, Player> playerlist = new HashMap<>();
    public int recievedRegisters;
    public Gameloop gameloop;
    public int numplayers;

    public GameServer(int numberofplayers) {
        server = new Server();
        numplayersconnected = 0;
        recievedRegisters = 0;

        System.out.println("Server started");
        server.start();
        network.register(server);
        gameloop = new Gameloop(this);
        this.numplayers = numberofplayers;

        try {
            server.bind(network.PORT, network.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }


        server.addListener(this);
    }
        public void connected(Connection c) {
                System.out.println("Recieved a connection from " + c.getRemoteAddressTCP().getHostString());
                numplayersconnected++;
                Player newPlayer = new Player(c.getID());
                playerlist.put(c.getID(), newPlayer);
                spillerliste.spillerliste.add(newPlayer);

                server.sendToAllTCP(spillerliste);


                if(numplayers == numplayersconnected) {
                    server.sendToAllTCP(new CardsPacket());
                }

                System.out.println("Currently Connected players: " + playerlist.size());

    }

    public void received (Connection c, Object object) {

        if(object instanceof MoveEvent) {
            MoveEvent event = (MoveEvent)object;
            server.sendToAllTCP(event);
        }
        if (object instanceof RotationEvent) {
            RotationEvent event = (RotationEvent)object;
            server.sendToAllTCP(event);
        }
        if( object instanceof PlayerCards) {
            recievedRegisters++;
            playerlist.get(c.getID()).lockedHand = ((PlayerCards) object).kort;
            System.out.println("Lockedhand motatt");
            System.out.println(c.getID());

            if(recievedRegisters == playerlist.size()) {
                gameloop.performTurn();
            }

        }
        if( object instanceof PowerDown) {
            server.sendToAllTCP(new PowerDown());
        }
    }



    public void sendNewCards(CardsPacket cards) {
        server.sendToAllTCP(cards);
    }



}
