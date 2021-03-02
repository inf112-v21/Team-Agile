package inf112.skeleton.app.Cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class PlayingCard extends Sprite {

    private final int WIDTH = 2;
    private final int HEIGHT = 3;
    public MoveType type;
    public int priority;
    public Texture texture;

    private BitmapFont font;




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



}



/*
Lage 1 klasse for kortene.
kort som endre direction (priority, direction)
kort som bevege antall steps i nåverende direction (steps, priority, direction (kan droppes) )
steps (0, 0, VEST)
steps (0, 1, NONE)
arraylist<Kortklasse>
2 arrays
 */