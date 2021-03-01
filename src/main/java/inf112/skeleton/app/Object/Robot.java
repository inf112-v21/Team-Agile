package inf112.skeleton.app.Object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.skeleton.app.Cards.PlayingCard;

import java.util.List;

public class Robot extends Sprite {

    private final int WIDTH = 1;
    private final int HEIGHT = 1;
    public int healthpoint;



    public Robot(TextureRegion texture, int xstart, int ystart) {
        setSize(WIDTH,HEIGHT);
        setRegion(texture);
        setOriginCenter();
        setPosition(xstart, ystart);
        this.healthpoint = 9;

    }

    public int getHealthpoint() {
        return healthpoint;
    }

}
