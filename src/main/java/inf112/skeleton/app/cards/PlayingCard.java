package inf112.skeleton.app.cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * PlayingCard oppretter et objekt for et enkelt
 * spillkort, og tar inn en type fra enumen
 * MoveType og en prioritet som bestemmer hvilken
 * rekkefølge hver av spillernes kort velges.
 *
 * @author Team Agile
 *
 */

public class PlayingCard extends Sprite {

    private final int WIDTH = 2;
    private final int HEIGHT = 3;
    public MoveType type;
    public int priority;
    public Texture texture;


    public PlayingCard(MoveType type, int priority ) {
        this.type = type;
        this.priority = priority;
        this.texture = type.getTexture();
        setSize(WIDTH,HEIGHT);
        setRegion(texture);

    }

    public MoveType getType() {
        return type;
    }

    public int getMove() {
        return type.getMove();
    }

    public int getPriority() {
        return priority;
    }


}
