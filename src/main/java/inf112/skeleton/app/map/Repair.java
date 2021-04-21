package inf112.skeleton.app.map;
import com.badlogic.gdx.math.Vector2;

public class Repair {

    Vector2 repairPos;
    int cellId;

    public static int repairOneHealth = 15;
    public static int repairTwoHealth = 7;

    public Repair(Vector2 wallPos, int cellId) {
        this.repairPos = wallPos;
        this.cellId = cellId;
    }

    public Vector2 getPosition() {
        return this.repairPos;
    }

    public int getCellId() {
        return this.cellId;
    }
}
