package inf112.skeleton.app.network;

import com.esotericsoftware.kryonet.Server;
import inf112.skeleton.app.network.Packets.Events.MoveEvent;
import inf112.skeleton.app.network.Packets.Events.RotationEvent;
import inf112.skeleton.app.network.Packets.Initialize.CardsPacket;
import inf112.skeleton.app.network.Packets.PlayingCardPair;
import inf112.skeleton.app.object.Player;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

public class Gameloop {

    int round;
    GameServer server;

    public Gameloop(GameServer server) {
        this.round = 0;
        this.server = server;

    }

    public void performTurn() {
        /*
        1. Robot power down if announced
        2. Robots move according to programcard
        3. Check boardElements (laser, booster)
        4. Fire lasers
        5. Flags/checkpoints
         */


        for (int i = 0; i < 5; i++) {
            performCard(i);

        }
        server.recievedRegisters = 0;
        server.server.sendToAllTCP(new CardsPacket());
    }

    private void performCard(int i) {

        int finalI = i;
        PriorityQueue<Player> spillere = new PriorityQueue<Player>(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return Integer.compare(o1.lockedHand.get(finalI).priority, o2.lockedHand.get(finalI).priority);
            }
        });
        spillere.addAll(server.playerlist.values());

        for (Player p : spillere) {

            if( p.lockedHand.size() > i) {
                PlayingCardPair kortet = p.lockedHand.get(i);

                if (kortet.move >= (-1) && kortet.move < 90) {
                    MoveEvent event = new MoveEvent(p.id, kortet.move);
                    server.server.sendToAllTCP(event);

                } else {
                    RotationEvent event = new RotationEvent(p.id, kortet.move);
                    server.server.sendToAllTCP(event);
                }

                long start = new Date().getTime();
                while (new Date().getTime() - start < 300L) {
                }
            }
        }
    }

}
