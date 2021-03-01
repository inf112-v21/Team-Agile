package inf112.skeleton.app.Cards;

import org.lwjgl.system.windows.MONITORINFOEX;

public class PlayingCard {

    MoveType type;
    int priority;

    public PlayingCard(MoveType type, int priority) {
        this.type = type;
        this.priority = priority;
    }

    int getMove() {
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