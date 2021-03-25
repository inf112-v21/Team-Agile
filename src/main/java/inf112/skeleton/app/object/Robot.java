package inf112.skeleton.app.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.cards.PlayingCard;
import inf112.skeleton.app.map.Wall;

import java.util.ArrayList;

public class Robot extends Sprite {

    private final int WIDTH = 1;
    private final int HEIGHT = 1;

    public int robotHealthPoint;

    RoboRally game;

    public String getName() {
        return name;
    }

    public String name;
    public ArrayList<PlayingCard> cards;
    public ArrayList<PlayingCard> lockedHand;

    public ArrayList<PlayingCard> getLockedHand() {
        return lockedHand;
    }



    public int flagToTake;
    Texture texture;
    TextureRegion[][] tr;
    TextureRegion normalState;
    TextureRegion deadState;
    TextureRegion winState;
    public int id;

    BitmapFont priorityfont = new BitmapFont(Gdx.files.internal("fonts/15green.fnt"));
    BitmapFont hudFont = new BitmapFont(Gdx.files.internal("fonts/17green.fnt"));


    public Robot(TextureRegion texture, int xstart, int ystart, String name) {

    }

    public Robot(TextureRegion texture, int xstart, int ystart) {
        setSize(WIDTH, HEIGHT);
        setRegion(texture);
        setOriginCenter();
        setPosition(xstart, ystart);
        this.name = name;
        this.robotHealthPoint = 9;
        this.cards = new ArrayList<>(robotHealthPoint);
        this.lockedHand = new ArrayList<>();
        this.flagToTake = 1;
    }

    public int getRobotHealthPoint() {
            return robotHealthPoint;
        }

    public Robot(int xstart, int ystart, Color color, int id, RoboRally game) {
        setSize(WIDTH, HEIGHT);
        initializeTexture();
        setRegion(normalState);
        setOriginCenter();
        setPosition(xstart, ystart);
        this.robotHealthPoint = 9;
        this.cards = new ArrayList<>(robotHealthPoint);
        this.lockedHand = new ArrayList<>();
        this.flagToTake = 1;
        this.id = id;
        setColor(color);
        this.game = game;
    }



        public void initializeTexture() {
        texture = new Texture(Gdx.files.internal("player.png"));
        tr = TextureRegion.split(texture, 300, 300);
        normalState = tr[0][0];
        deadState = tr[0][1];
        winState = tr[0][2];
    }

    public void changeState(String state) {
        switch (state) {
            case ("normal"):
                this.setRegion(normalState);
                break;
            case ("dead"):
                this.setRegion(deadState);
                break;
            case ("win"):
                this.setRegion(winState);
                break;
        }
    }

    public void push(Robot otherplayer) {
        //if the player is pushing another robot, it needs to make sure that
        //the other player is being moved
    }

    public void getPushed() {
        //the player gets pushed and gets moved
    }

    public boolean isPushing(Robot otherplayer) {
        //check for if the player is moving towards another player and doing a push
        return true;
    }

    public boolean isBeingpushed(Robot player, Robot otherplayer) {
        //if the player is being pushed and hits a wall, both the player and the
        //other player must stop
        if (otherplayer.isPushing(player)) {
            return true;
        }
        return false;
    }


    public ArrayList<PlayingCard> getCards() {
        return cards;
    }


    public void playerCardstoHand(ArrayList<PlayingCard> spillerkort) {
        int x = 18;
        int y = 10;
        for (int i = 0; i < spillerkort.size() ; i++ ) {
            PlayingCard nvKort = spillerkort.get(i);
            nvKort.setPosition( x,  y);
            x += 2;
            if(x == 28) {
                x = 19;
                y = 7;
            }
        }
    }

    public void playerLocked(ArrayList<PlayingCard> lockedkort) {
        int x = 18;
        int y = 3;
        for (int i = 0; i < lockedkort.size() ; i++ ) {
            PlayingCard kort = lockedkort.get(i);
            kort.setPosition( x, y);
            x += 2;
        }
    }

    public void renderCards(Batch batch) {
        for (PlayingCard kort : cards) {
            kort.draw(batch);
        }
        for (PlayingCard locked : lockedHand) {
            locked.draw(batch);
        }
    }

    public void renderPriority(Batch batch) {
        float xStart = 882;
        float yStart = 682f;

        for (PlayingCard kort : cards) {
            int priority = kort.getPriority();
            priorityfont.draw(batch, Integer.toString(priority), xStart , yStart);
            xStart += 92;

            if(xStart == 1342) {
                xStart = 930;
                yStart = 520;
            }
        }
        xStart = 882;
        yStart = 307;
        for (PlayingCard locked : lockedHand) {
            int priority = locked.getPriority();
            priorityfont.draw(batch, Integer.toString(priority), xStart , yStart);
            xStart += 92;
        }
    }

    public void initializeHud(Batch batch){
        hudFont.draw(batch, ("Player: " + id), 30, 80);
        hudFont.draw(batch, ("HP = " + robotHealthPoint), 750, 80);
    }

    public void renderHud(String text, SpriteBatch batch, int hudPosition){
        BitmapFont hudFont = new BitmapFont(Gdx.files.internal("fonts/17green.fnt"));
        batch.begin();
        if(hudPosition == 0){ hudFont.draw(batch, text, 500, 55); }
        else{ hudFont.draw(batch, text, 1151,55); }
        batch.end();
    }

    public void visitFlag(int flagID) {
        if (flagID > flagToTake) {
            return;
        }
        if (flagID == flagToTake) {
            flagToTake += 1;
            System.out.println("flag: " + flagID + " was taken by player " + this.id);
            System.out.println("player " + this.id + " next flag to take " + flagToTake);
        }
    }

    public Integer getFlag() {
        return flagToTake;
    }
/*
    public void move(int steps) {
        switch ((int) this.getRotation()) {
            case(0):
                this.setPosition(this.getX(), this.getY() - steps);
                break;
            case(90):
                this.setPosition(this.getX() + steps, this.getY());
                break;
            case(180):
                this.setPosition(this.getX(), this.getY() + steps);
                break;
            case(270):
                this.setPosition(this.getX() - steps, this.getY());
                break;
        }
    }

 */
public void move(int steps) {
    switch ((int) this.getRotation()) {
        case(0):
            for(int i = 1; i <= steps; i++){
                if(checkForWall(this, 0, -1)){
                    System.out.println("1aNot possible to make that move, because of wall");
                }
                else{ this.setPosition(this.getX(), this.getY() - 1); }
            }
            break;

        case(90):
            for(int i = 1; i <= steps; i++){
                if(checkForWall(this, 1, 0)){
                    System.out.println("2aNot possible to make that move, because of wall");
                }
                else{
                    this.setPosition(this.getX() + 1, this.getY());}
            }
            break;

        case(180):
            for(int i = 1; i <= steps; i++){
                if(checkForWall(this, 0, 1)){
                    System.out.println("3Not possible to make that move, because of wall");
                }
                else{this.setPosition(this.getX(), this.getY() + 1);}
            }
            break;

        case(270):
            for(int i = 1; i <= steps; i++){
                if(checkForWall(this, -1, 0)){
                    System.out.println("4Not possible to make that move, because of wall");
                }
                else{this.setPosition(this.getX() - 1, this.getY());}
            }
            break;

    }
}
    public boolean checkForWall(Robot player, int xDiff, int yDiff){
        System.out.println("checkwall");
        for (Wall wall : game.allWalls){
            if(wall.isWallInFrontOfPlayer(player) || wall.isWallInNextTile(player, xDiff, yDiff)) {
                return true;
            }
        }
        return false;
    }

    public void rotate(int degree) {
        this.setRotation(this.getRotation() + degree);
        resetDegrees((int) this.getRotation());
    }

    private void resetDegrees(int degree) {
        if (degree == 360) {
            this.setRotation(0);
        } else if(degree < 0) {
            this.setRotation(270);
        } else if(degree == 450) {
            this.setRotation(90);
        }
    }

    public void decreaseRobotHealthpoint(int healthpoint){
        this.robotHealthPoint -= healthpoint;
    }



}

