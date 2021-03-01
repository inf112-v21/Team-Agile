package inf112.skeleton.app.Cards.CardTypes;

public class CardForwardThree implements ICard {

    int priority = 0;

    public CardForwardThree (int priority) {
        this.priority = priority;
    }

    public String getCardType() {
        return "movecard";
    }


    public String getCardName() {
        return null;
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
