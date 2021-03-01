package inf112.skeleton.app.Cards.CardTypes;

public class CardForwardOne implements ICard {

    int priority = 0;

    public CardForwardOne (int priority) {
        this.priority = priority;
    }

    public String getCardType() {
        return "movecard";
    }

<<<<<<< HEAD
    @Override
    public String getCardName() {
        return null;
    }

=======
    public int getRotationDegrees() {
        return 0;
    }
>>>>>>> 4c25317a9b132462176ba11b42f27d1b0c3571b2

    public int getTimesMoveForward() {
        return 1;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }
}
