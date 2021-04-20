package inf112.skeleton.app.map;

import com.badlogic.gdx.math.Vector2;

public enum DirectionEnum {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Vector2 GoInDir(Vector2 position, DirectionEnum direction) {
        Vector2 nextPosition = position.cpy();

        switch (direction) {
            case NORTH:
                return nextPosition.add(0, 1);
            case SOUTH:
                return nextPosition.add(0, -1);
            case WEST:
                return nextPosition.add(-1, 0);
            case EAST:
                return nextPosition.add(1, 0);

            default: throw new IllegalArgumentException("Illegal direction.");
        }
    }
}
