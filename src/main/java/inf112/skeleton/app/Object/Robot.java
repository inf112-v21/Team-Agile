package inf112.skeleton.app.Object;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.skeleton.app.Cards.PlayingCard;
import inf112.skeleton.app.Cards.PlayingCardHand;

import java.util.ArrayList;
import java.util.List;

public class Robot extends Sprite {

    private final int WIDTH = 1;
    private final int HEIGHT = 1;
    public int healthpoint;
    private ArrayList<PlayingCard> cards;
    private ArrayList<PlayingCardHand> hand;



    public Robot(TextureRegion texture, int xstart, int ystart) {
        setSize(WIDTH, HEIGHT);
        setRegion(texture);
        setOriginCenter();
        setPosition(xstart, ystart);
        this.healthpoint = 5;
        this.cards = new ArrayList<>(healthpoint);
        this.hand = new ArrayList<>(healthpoint);

    }
    public ArrayList<PlayingCardHand> getHand() {
        return hand;
    }



    public int getHealthpoint() {
        return healthpoint;
    }


    public ArrayList<PlayingCard> getCards() {
        return cards;
    }


    public void playerCardstoHand(ArrayList<PlayingCard> spillerkort) {
        int x = 14;
        int y = 10;
        for (int i = 0; i < spillerkort.size() ; i++ ) {
            PlayingCardHand kort = new PlayingCardHand(spillerkort.get(i).texture , x, y);
            hand.add(kort);
            x += 2;
            if(x == 24 ) {
                x = 15;
                y = 7;
            }
        }
    }

    public void render(Batch batch) {
        for (PlayingCardHand kort : hand) {
            kort.draw(batch);
        }
    }
}

