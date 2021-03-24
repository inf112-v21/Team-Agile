package inf112.skeleton.app.network.Packets;

import java.util.ArrayList;
import java.util.Map;

public class PlayingCardPair {

    public Integer move, priority;

    public PlayingCardPair() {

    }

    public PlayingCardPair(int move, int priority) {
        this.move = move;
        this.priority = priority;
    }

    public int compareTo(PlayingCardPair kort) {
        return kort.priority - priority;
    }
}
