package inf112.skeleton.app.Cards;

import org.lwjgl.system.windows.MONITORINFOEX;

public class Programcard {


    public enum MoveType {
        BACKUP(-1),
        UTURN(Rotate(180)),
        ROTATE_RIGHT(0, rotate(med klokken)),
        ROTATE_LEFT(0, rotate(mot klokken)),
        MOVEONE(1, 0),
        MOVETWO(2,0),
        MOVETHREE(3,0);

        private final int steps;
        private final Rotation rotate;
        private MoveType(int steps, Rotation rotate){
            this.steps = steps;
            this.direction = direction;


        }
    }



    public enum Direction {
        SOUTH,
        WEST,
        NORTH,
        EAST;

        private static final Direction[] dir = Direction.values();

        public static Direction getDir(int i) {
            return Direction.dir[i];
        }
    }



    /*
    libgdx metode rotate på selve Sprite (bilde objektet) brukes med angitt grader. (0-360) , 0 samme, 90
     */

    MoveType type;
    int priority;
    Direction direction;

    public Programcard(MoveType type, int priority, Direction direction) {
        this.type = type;
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