package inf112.skeleton.app.Cards.CardTypes;

public class CardForwardTwo implements ICard {

    int priority = 0;

    public CardForwardTwo (int priority) {
        this.priority = priority;
    }

    public String getCardType() {
        return "movecard";
    }

    public int getRotationDegrees() {
        return 0;
    }

    public int getTimesMoveForward() {
        return 2;
    }

    public int getPriority() {
        return this.priority;
    }
}
