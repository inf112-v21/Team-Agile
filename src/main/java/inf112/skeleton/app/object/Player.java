package inf112.skeleton.app.object;

import inf112.skeleton.app.network.Packets.PlayingCardPair;

import java.util.ArrayList;

public class Player {

    public int x, y, id;
    public ArrayList<PlayingCardPair> lockedHand;

    public Player() {
    }

    public Player(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.lockedHand = new ArrayList<>();
    }
}
