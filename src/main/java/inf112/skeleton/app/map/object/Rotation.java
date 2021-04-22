package inf112.skeleton.app.map.object;
import com.badlogic.gdx.math.Vector2;

public class Rotation {

    Vector2 rotationPos;
    int cellId;

    public static int rotateLeft = 53;
    public static int rotateRight = 54;

    public Rotation(Vector2 wallPos, int cellId) {
        this.rotationPos = wallPos;
        this.cellId = cellId;
    }

    public Vector2 getPosition() {
        return this.rotationPos;
    }

    public int getCellId() {
        return this.cellId;
    }
}
