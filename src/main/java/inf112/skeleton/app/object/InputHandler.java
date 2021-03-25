package inf112.skeleton.app.object;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import inf112.skeleton.app.RoboRally;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.PlayingCard;
import inf112.skeleton.app.map.Laser;
import inf112.skeleton.app.map.Wall;

import java.util.ArrayList;
import inf112.skeleton.app.network.Packets.Events.MoveEvent;
import inf112.skeleton.app.network.Packets.Events.RotationEvent;

public class InputHandler extends InputAdapter {

    Robot player;
    ArrayList<Wall> walls;
    ArrayList<Laser> lasers;
    RoboRally game;

    public InputHandler(RoboRally game, Robot player, ArrayList<Wall> walls, ArrayList<Laser> lasers) {
        this.game = game;
        this.player = player;
        this.walls = walls;
        this.lasers = lasers;
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
                game.client.sendCards(game.clientPlayer.lockedHand);
                game.clientPlayer.getLockedHand().clear();
                game.clientPlayer.cards.clear();
                break;
            case Input.Keys.C:
                game.gameState = "check";
                break;
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



    public void setHandler(Robot robot) {
        player = robot;

    }

}
