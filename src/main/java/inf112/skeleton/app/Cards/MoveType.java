package inf112.skeleton.app.Cards;

public enum MoveType {
    BACKUP(-1),
    UTURN(180),
    ROTATE_RIGHT(90),
    ROTATE_LEFT(-90),
    MOVEONE(1),
    MOVETWO(2),
    MOVETHREE(3);

    private int move;

    int getMove() {
        return move;
    }

    MoveType(int move) {
        this.move = move;
    }

}