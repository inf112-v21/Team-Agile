package inf112.skeleton.app.Cards.CardTypes;

public class CardUTurn implements IRotateCard {

    private int priority = 0;

    public CardUTurn (int priority) {
        this.priority = priority;
    }

    public String getCardType() {
        return "UTurn";
    }

    @Override
    public String getCardName() {
        return null;
    }

    @Override
    public void setPriority(int priority) {

    }

    public int getRotationDegrees() {
        return 180;
    }

    public int getTimesMoveForward() {
        return 0;
    }

    public int getPriority() {
        return this.priority;
    }
}
