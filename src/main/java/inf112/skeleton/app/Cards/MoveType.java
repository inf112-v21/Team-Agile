package inf112.skeleton.app.Cards;

import com.badlogic.gdx.graphics.Texture;
import org.w3c.dom.Text;

public enum MoveType {
    BACKUP(-1, new Texture("backUp.png")),
    UTURN(180, new Texture("rotate.png")),
    ROTATE_RIGHT(90, new Texture("RotateRight.png")),
    ROTATE_LEFT(-90, new Texture("RotateLeft.png")),
    MOVEONE(1, new Texture("move1.png")),
    MOVETWO(2, new Texture("move2.png")),
    MOVETHREE(3, new Texture("move3.png"));

    private int move;


    private Texture texture;


    int getMove() {
        return move;
    }

    public Texture getTexture() {
        return texture;
    }

    MoveType(int move, Texture texture) {
        this.move = move;
        this.texture = texture;

    }

}