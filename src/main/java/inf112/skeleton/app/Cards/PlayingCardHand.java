package inf112.skeleton.app.Cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class PlayingCardHand extends Sprite {

    private final int WIDTH = 1;
    private final int HEIGHT = 2;

    private ArrayList<PlayingCard> hand;
    Texture texture;
    TextureRegion[][] tr;
    TextureRegion BACKUP;
    TextureRegion UTURN;
    TextureRegion MOVEONE;

    Deck deck = new Deck();


    public PlayingCardHand(Texture texture, int x , int y) {
        setPosition( x, y);
        setSize(WIDTH,HEIGHT);
        setRegion(texture);

    }

    public void initializeTextureRegions(Texture texture) {
        tr = TextureRegion.split(texture, 300, 300);


    }

    public void getHand() {
        for(int i = 0 ; i < 9 ; i++) {


        };
    }



}
