package inf112.skeleton.app.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.network.Packets.*;
import inf112.skeleton.app.network.Packets.Events.ChangePhase;
import inf112.skeleton.app.network.Packets.Events.MoveEvent;
import inf112.skeleton.app.network.Packets.Events.PowerDown;
import inf112.skeleton.app.network.Packets.Events.RotationEvent;
import inf112.skeleton.app.network.Packets.Initialize.CardsPacket;
import inf112.skeleton.app.network.Packets.Initialize.CreateRobot;
import inf112.skeleton.app.network.Packets.Initialize.InputhandlerPacket;
import inf112.skeleton.app.network.Packets.Initialize.PlayerList;
import inf112.skeleton.app.map.object.Player;

import java.util.ArrayList;

public class NetworkHandler {

    public static final int PORT = 8080;
    public static final String IPAddress = "localhost";

    public static void register(EndPoint endPoint) {

        Kryo kryo = endPoint.getKryo();
        kryo.register(PlayerList.class);
        kryo.register(ArrayList.class);
        kryo.register(RoboRally.class);
        kryo.register(CreateRobot.class);
        kryo.register(Player.class);
        kryo.register(MoveEvent.class);
        kryo.register(RotationEvent.class);
        kryo.register(CardsPacket.class);
        kryo.register(PlayerCards.class);
        kryo.register(PlayingCardPair.class);
        kryo.register(InputhandlerPacket.class);
        kryo.register(ChangePhase.class);
        kryo.register(PowerDown.class);

    }
}
