package inf112.skeleton.app.object;

import inf112.skeleton.app.network.Packets.PlayingCardPair;

import java.util.ArrayList;

public class Player {

    public int id;
    public ArrayList<PlayingCardPair> lockedHand;

    public Player() {
    }

    public Player(int id) {
        this.id = id;
        this.lockedHand = new ArrayList<>();
    }
}
