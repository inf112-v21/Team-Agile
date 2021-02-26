package inf112.skeleton.app.Cards.CardTypes;

public interface IMoveCard extends ICard {

    public String getCardType();

    public String getCardName();

    public void setPriority(int priority);

    public int getTimesMoveForward();

    public int getPriority();

}
