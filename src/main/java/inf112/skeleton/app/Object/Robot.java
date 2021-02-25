package inf112.skeleton.app.Object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Robot extends Sprite {

    private final int WIDTH = 1;
    private final int HEIGHT = 1;

    public Robot(TextureRegion texture, int xstart, int ystart) {
        setSize(WIDTH,HEIGHT);
        setRegion(texture);
        setOriginCenter();
        setPosition(xstart, ystart);

    }
}
