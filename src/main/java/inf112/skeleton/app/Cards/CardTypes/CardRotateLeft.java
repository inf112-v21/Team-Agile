package inf112.skeleton.app.Cards.CardTypes;

public class CardRotateLeft implements ICard {

    int priority = 0;

    public CardRotateLeft (int priority) {
        this.priority = priority;
    }

    public String getCardType() {
        return "rotatecard";
    }

    @Override
    public String getCardName() {
        return null;
    }

    @Override
    public void setPriority(int priority) {

    }

    public int getRotationDegrees() {
        return -90;
    }

    public int getTimesMoveForward() {
        return 0;
    }

    public int getPriority() {
        return this.priority;
    }
}