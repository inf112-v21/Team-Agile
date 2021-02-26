package inf112.skeleton.app.Cards.CardTypes;

public class CardBackup implements ICard {

    private int priority = 0;

    public CardBackup (int priority) {
        this.priority = priority;
    }

    public String getCardType() {
        return "movecard";
    }

    public String getCardName() {
        return "backup";
    }

    public int getRotationDegrees() {
        return 0;
    }

    public int getTimesMoveForward() {
        return -1;
    }

    public int getPriority() {
        return this.priority;
    }
}
