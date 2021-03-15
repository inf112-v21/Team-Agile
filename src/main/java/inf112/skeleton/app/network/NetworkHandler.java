package inf112.skeleton.app.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class NetworkHandler {

    public static final int PORT = 8080;
    public static final String IPAddress = "localhost";

    public static void register(EndPoint endPoint) {

        Kryo kryo = endPoint.getKryo();


    }
}
