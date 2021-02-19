package inf112.skeleton.app;

public class Programcard {



    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        private static final Direction[] dir = Direction.values();
        public static Direction getDir(int i) {
            return Direction.dir[i];
        }
    }

    int steps;
    int priority;
    int direction;

    public Programcard(int steps, int priority, int direction) {
        this.steps = steps;
        this.priority = priority;
        this.direction = direction;
    }

    public int getSteps() {
        return steps;
    }

    public int getDirection() {
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