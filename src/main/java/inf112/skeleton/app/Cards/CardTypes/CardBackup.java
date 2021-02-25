package inf112.skeleton.app.Cards.CardTypes;

public class CardBackup implements ICard {

    int priority = 0;

    public int getRotationDegrees() {
        return 0;
    }

    public int getTimesMoveForward() {
        return -1;
    }

    public void setPriority() {
        //this.priority = (430-480, intervall)
    }

    public int getPriority() {
        return this.priority;
    }
}
