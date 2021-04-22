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
                player.move(1);
                game.client.sendMove(new MoveEvent(game.client.getID(), 1));
                break;
            case Input.Keys.DOWN:
                player.move(-1);
                game.client.sendMove(new MoveEvent(game.client.getID(), -1));
                break;
            case Input.Keys.LEFT:
                player.rotate(90);
                game.client.sendRotation(new RotationEvent(game.client.getID(), 90));
                break;
            case Input.Keys.RIGHT:
                rotate(-90);
                game.client.sendRotation(new RotationEvent(game.client.getID(), -90));
                break;
            case Input.Keys.R:
                rotate(180);
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
            if(screenX > 925 && screenX < 1095 && screenY > 360 && screenY < 403 ) {
                powerDown();
            }
            if(screenX > 1140 && screenX < 1302 && screenY > 360 && screenY < 403 ) {
                lockInHand();
            }
            if(screenX > 1060 && screenX < 1191 && screenY > 600 && screenY < 637 ) {
                exitGame();
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

    public boolean checkForWall(Robot player, int xDiff, int yDiff){
        for (Wall wall : walls){
            if(wall.isWallInFrontOfPlayer(player) || wall.isWallInNextTile(player, xDiff, yDiff)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkForLaser(Robot player){
        for (Laser laser : lasers){
            if(laser.isLaserInFrontOfPlayer(player)){
                return true;
            }
        }
        return false;
    }


    public void move(int steps) {
        switch ((int) player.getRotation()) {
            case(0):
                for(int i = 1; i <= steps; i++){
                    if(checkForWall(player, 0, -1)){
                        System.out.println("Not possible to make that move, because of wall");
                    }
                    else{ player.setPosition(player.getX(), player.getY() - 1); }
                }
                break;

            case(90):
                for(int i = 1; i <= steps; i++){
                    if(checkForWall(player, 1, 0)){
                        System.out.println("Not possible to make that move, because of wall");
                    }
                    else{
                        player.setPosition(player.getX() + 1, player.getY());}
                }
                break;

            case(180):
                for(int i = 1; i <= steps; i++){
                    if(checkForWall(player, 0, 1)){
                        System.out.println("Not possible to make that move, because of wall");
                    }
                    else{player.setPosition(player.getX(), player.getY() + 1);}
                }
                break;

            case(270):
                for(int i = 1; i <= steps; i++){
                    if(checkForWall(player, -1, 0)){
                        System.out.println("Not possible to make that move, because of wall");
                    }
                    else{player.setPosition(player.getX() - 1, player.getY());}
                }
                break;
        }
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
    }

    public void setHandler(Robot robot) {
        player = robot;

    }

}
