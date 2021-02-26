package inf112.skeleton.app.Cards.CardTypes;

public class CardRotateRight implements IRotateCard {

    private int priority = 0;

    public CardRotateRight (int priority) {
        this.priority = priority;
    }

    public String getCardType() {
        return "rotatecard";
    }

    public int getRotationDegrees() {
        return 90;
    }

    public int getTimesMoveForward() {
        return 0;
    }

    public int getPriority() {
        return this.priority;
    }
}
