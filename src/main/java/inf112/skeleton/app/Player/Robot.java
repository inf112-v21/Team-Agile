package inf112.skeleton.app.Player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Robot extends Sprite {

    private final int WIDTH = 1;
    private final int HEIGHT = 1;

    public Robot(TextureRegion texture, int xstart, int ystart) {
        setSize(WIDTH,HEIGHT);
        setRegion(texture);
        setOriginCenter();

    }
}
