package inf112.skeleton.app.map.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.cards.PlayingCard;
import inf112.skeleton.app.map.Wall;

import java.util.ArrayList;
import inf112.skeleton.app.network.Packets.Events.MoveEvent;
import inf112.skeleton.app.network.Packets.Events.PowerDown;
import inf112.skeleton.app.network.Packets.Events.RotationEvent;

public class InputHandler extends InputAdapter implements InputProcessor {

    Robot player;
    ArrayList<Wall> walls;
    ArrayList<Laser> lasers;
    RoboRally game;


    public InputHandler(RoboRally game, Robot player) {
        this.game = game;
        this.player = player;
        this.walls = game.allWalls;
        this.lasers = game.allLasers;
    }


    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                //player.move(1);
                game.client.sendMove(new MoveEvent(game.client.getID(), 1));
                break;
            case Input.Keys.DOWN:
                //player.move(-1);
                game.client.sendMove(new MoveEvent(game.client.getID(), -1));
                break;
            case Input.Keys.LEFT:
                //player.rotate(90);
                game.client.sendRotation(new RotationEvent(game.client.getID(), 90));
                break;
            case Input.Keys.RIGHT:
                //rotate(-90);
                game.client.sendRotation(new RotationEvent(game.client.getID(), -90));
                break;
            case Input.Keys.R:
                //rotate(180);
                game.client.sendRotation(new RotationEvent(game.client.getID(), 180));
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
                performCardinRegister();
                break;
            case Input.Keys.ENTER:
                lockInHand();
                break;
            case Input.Keys.P:
                powerDown();
            case Input.Keys.C:
                game.phase = "check";
                break;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(button == Input.Buttons.LEFT) {
            if(screenX > 870 && screenX < 960 && screenY > 52 && screenY < 190 ) {
                moveToLocked(0);
            }
            if(screenX > 961 && screenX < 1051 && screenY > 52 && screenY < 190 ) {
                moveToLocked(1);
            }
            if(screenX > 1052 && screenX < 1141 && screenY > 52 && screenY < 190 ) {
                moveToLocked(2);
            }
            if(screenX > 1142 && screenX < 1232 && screenY > 52 && screenY < 190 ) {
                moveToLocked(3);
            }
            if(screenX > 1233 && screenX < 1323 && screenY > 52 && screenY < 190 ) {
                moveToLocked(4);
            }
            if(screenX > 918 && screenX < 1008 && screenY > 190 && screenY < 336 ) {
                moveToLocked(5);
            }
            if(screenX > 1009 && screenX < 1098 && screenY > 190 && screenY < 336 ) {
                moveToLocked(6);
            }
            if(screenX > 1099 && screenX < 1189 && screenY > 190 && screenY < 336 ) {
                moveToLocked(7);
            }
            if(screenX > 1190 && screenX < 1280 && screenY > 190 && screenY < 336 ) {
                moveToLocked(8);
            }
            if(screenX > 1136 && screenX < 1304 && screenY > 564 && screenY < 630 ) {
                powerDown();
            }
            if(screenX > 909 && screenX < 1084 && screenY > 564 && screenY < 630 ) {
                lockInHand();
            }
            if(screenX > 1365 && screenX < 1399 && screenY > 0 && screenY < 25 ) {
                exitGame();
            }
            if(screenX > 1017 && screenX < 1195 && screenY > 314 && screenY < 348 ) {
                resetLockedHand();
            }

        }
        if(button == Input.Buttons.RIGHT) {
            resetLockedHand();
        }
        return false;

    }

    public void performCardinRegister() {
        if (player.getLockedHand().size() > 0) {
            PlayingCard kortet = player.getLockedHand().remove(0);
            int movetype = kortet.getMove();
            if (movetype < 4 && movetype != -90) {
                player.move(movetype);
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

    public void rotate(int degree) {
        player.setRotation(player.getRotation() + degree);
        resetDegrees((int) player.getRotation());
    }

    public void powerDown() {
        game.client.sendPowerDown(new PowerDown(game.client.getID()));
        game.clientPlayer.getLockedHand().clear();
        game.clientPlayer.cards.clear();
        game.client.sendCards(game.clientPlayer.lockedHand);
    }

    public void lockInHand() {
        game.client.sendCards(game.clientPlayer.lockedHand);
        game.clientPlayer.getLockedHand().clear();
        game.clientPlayer.cards.clear();
    }

    public void exitGame(){
        Gdx.app.exit();
        System.exit(0);
    }

    public void setHandler(Robot robot) {
        player = robot;

    }

}
