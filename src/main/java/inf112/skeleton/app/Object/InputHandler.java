package inf112.skeleton.app.Object;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import inf112.skeleton.app.Cards.PlayingCard;

public class InputHandler extends InputAdapter {

    Robot player;

    int dir = 0;

    public InputHandler(Robot player) {
        this.player = player;
    }


    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                move(1);
                break;
            case Input.Keys.DOWN:
                move(-1);
                break;
            case Input.Keys.LEFT:
                rotate(90);
                break;
            case Input.Keys.RIGHT:
                rotate(-90);
                break;
            case Input.Keys.R:
                rotate(180);
                break;
            case Input.Keys.NUM_1:
                moveToLocked(0);
                break;
            case Input.Keys.NUM_2:
                moveToLocked(1);
                break;
            case Input.Keys.NUM_3:
                moveToLocked(2);
                break;
            case Input.Keys.NUM_4:
                moveToLocked(3);
                break;
            case Input.Keys.NUM_5:
                moveToLocked(4);
                break;
            case Input.Keys.NUM_6:
                moveToLocked(5);
                break;
            case Input.Keys.NUM_7:
                moveToLocked(6);
                break;
            case Input.Keys.NUM_8:
                moveToLocked(7);
                break;
            case Input.Keys.NUM_9:
                moveToLocked(8);
                break;

            case Input.Keys.A:
                resetLockedHand();
                break;
            case Input.Keys.SPACE:
                performCard();
                break;
        }
        return false;
    }
    public void performCard() {
        if (player.getLockedHand().size() > 0) {
            PlayingCard kortet = player.getLockedHand().remove(0);
            int movetype = kortet.getMove();
            if (movetype < 4 && movetype != -90) {
                move(movetype);
            } else {
                rotate(movetype);
            }
            player.playerLocked(player.getLockedHand());
        }
    }


    public void resetLockedHand() {
        for (PlayingCard card: player.getLockedHand()) {

            player.getCards().add(card);
            player.playerCardstoHand(player.getCards());
        }
        player.getLockedHand().clear();
    }


    public void moveToLocked(int index) {
        if(player.getLockedHand().size() == 5 || player.getCards().size() <= index) {
            return;
        } else {
            player.getLockedHand().add(player.getCards().remove(index));
            player.playerLocked(player.getLockedHand());
            player.playerCardstoHand(player.getCards());
        }
    }




    private void resetDegrees(int degree) {
        if (degree == 360) {
            player.setRotation(0);
        } else if(degree < 0) {
            player.setRotation(270);
        } else if(degree == 450) {
            player.setRotation(90);
        }
    }

    private void rotate(int degree) {
        player.setRotation(player.getRotation() + degree);
        resetDegrees((int) player.getRotation());
    }

    //1
    private void move(int steps) {
        switch ((int) player.getRotation()) {
            case(0):
                player.setPosition(player.getX(), player.getY() - steps);
                break;
            case(90):
                player.setPosition(player.getX() + steps, player.getY());
                break;
            case(180):
                player.setPosition(player.getX(), player.getY() + steps);
                break;
            case(270):
                player.setPosition(player.getX() - steps, player.getY());
                break;
        }
    }

}
