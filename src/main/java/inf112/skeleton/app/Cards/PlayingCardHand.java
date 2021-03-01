package inf112.skeleton.app.Cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.skeleton.app.HelloWorld;

import java.util.ArrayList;

public class PlayingCardHand extends Sprite {

    private final int WIDTH = 2;
    private final int HEIGHT = 3;
    
    public PlayingCardHand(Texture texture, int x , int y) {
        setPosition( x, y);
        setSize(WIDTH,HEIGHT);
        setRegion(texture);
    }
}
