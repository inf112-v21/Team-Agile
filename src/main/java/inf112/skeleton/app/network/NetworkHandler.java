package inf112.skeleton.app.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.cards.MoveType;
import inf112.skeleton.app.network.Packets.*;
import inf112.skeleton.app.object.Player;
import inf112.skeleton.app.object.Robot;

import java.util.ArrayList;

public class NetworkHandler {

    public static final int PORT = 8080;
    public static final String IPAddress = "localhost";

    public static void register(EndPoint endPoint) {

        Kryo kryo = endPoint.getKryo();
        kryo.register(Packet.class);
        //kryo.register(Robot.class);
        kryo.register(PlayerList.class);
        kryo.register(ArrayList.class);
        kryo.register(RoboRally.class);
        kryo.register(GameEvent.class);
        kryo.register(CreateRobot.class);
        kryo.register(InputHandlerPacket.class);
        kryo.register(Player.class);
        kryo.register(MoveEvent.class);
        kryo.register(RotationEvent.class);
        kryo.register(CardsPacket.class);


    }
}
