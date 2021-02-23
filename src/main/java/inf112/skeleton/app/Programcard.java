package inf112.skeleton.app;

import org.lwjgl.system.windows.MONITORINFOEX;

public class Programcard {


    public enum MoveType {
        BACKUP,
        UTURN,
        ROTATE_RIGHT,
        ROTATE_LEFT,
        MOVEONE,
        MOVETWO,
        MOVETHREE;
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
        this.priority = priority;
        this.direction = direction;
    }

    public MoveType getSteps() {
        return type;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getPriority() {
        return priority;
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