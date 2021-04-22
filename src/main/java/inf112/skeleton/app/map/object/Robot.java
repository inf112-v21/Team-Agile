package inf112.skeleton.app.map.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.cards.PlayingCard;
import inf112.skeleton.app.map.Wall;

import java.util.ArrayList;

/**
 * Robot klassen holder styr på alle egenskaper til roboten
 * som styres av en spiller. Klassen holder styr på nåværende
 * helsepoeng, logikk for bevegelse og hvordan roboten
 * interakterer med andre spilleres robot.
 *
 * @author Team Agile
 *
 */

public class Robot extends Sprite {

    private final int WIDTH = 1;
    private final int HEIGHT = 1;

    //private RoboRally game;
    //private boolean cannotmove = false;

    public void setRobotHealthPoint(int robotHealthPoint) {
        this.robotHealthPoint = robotHealthPoint;
    }

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

    ArrayList<Robot> otherrobots;



    public int flagToTake;
    Texture texture;
    TextureRegion[][] tr;
    TextureRegion normalState;
    TextureRegion deadState;
    TextureRegion winState;
    public int id;
    public Vector2 checkpoint;
    public int lives;

    public void setPowerdownpos(Vector2 powerdownpos) {
        this.powerdownpos = powerdownpos;
    }

    public Vector2 powerdownpos;

    BitmapFont priorityfont = new BitmapFont(Gdx.files.internal("fonts/15green.fnt"));
    BitmapFont hudFont = new BitmapFont(Gdx.files.internal("fonts/17green.fnt"));


    public Robot(TextureRegion texture, int xstart, int ystart, String name) {

    }

    public Robot(TextureRegion texture, int xstart, int ystart) {
        setSize(WIDTH, HEIGHT);
        setRegion(texture);
        setOriginCenter();
        setPosition(xstart, ystart);
        setRotation(0);
        this.name = name;
        this.robotHealthPoint = 9;
        this.cards = new ArrayList<>(robotHealthPoint);
        this.lockedHand = new ArrayList<>();
        this.otherrobots = new ArrayList<>();
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
        setRotation(90);
        this.robotHealthPoint = 9;
        this.cards = new ArrayList<>(robotHealthPoint);
        this.lockedHand = new ArrayList<>();
        this.otherrobots = new ArrayList<>();

        this.flagToTake = 1;
        this.id = id;
        setColor(color);
        this.game = game;
        this.checkpoint = new Vector2(xstart,ystart);
        this.lives = 3;

    }



        public void initializeTexture() {
        texture = new Texture(Gdx.files.internal("player.png"));
        tr = TextureRegion.split(texture, 300, 300);
        normalState = tr[0][0];
        deadState = tr[0][1];
        winState = tr[0][2];
    }

    public Vector2 getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(Vector2 checkpoint) {
        this.checkpoint = checkpoint;
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

    public boolean checkForPlayer(int rot) {
        //kjente bugs:
        //om spilleren går baklengs mens han
        //står mot en annen spiller, så
        //backer begge off (feature, not a bug?)

        int x = (int) this.getX();
        int y = (int) this.getY();

        switch (rot) {
            case (0):
                for (Robot r : game.robots) {
                    if ((x == r.getX()) && ((y - 1) == r.getY())) {
                        if(checkForWall(r, 0, -1)) {
                        } else { r.setPosition(r.getX(), r.getY() -1); }
                        return true;
                    }
                }
                break;
            case (90):
                for (Robot r : game.robots) {
                    if (((x + 1) == r.getX()) && (y == r.getY())) {
                        if(checkForWall(r, 1, 0)) {
                        } else { r.setPosition(r.getX() + 1, r.getY()); }
                        return true;
                    }
                }
                break;
            case (180):
                for (Robot r : game.robots) {
                    if ((x == r.getX()) && ((y + 1) == r.getY())) {
                        if (checkForWall(r, 0, 1)) {

                        }
                        else {
                            r.setPosition(r.getX(), r.getY() + 1);
                        }
                        return true;
                    }
                }
                break;
            case (270):
                for (Robot r : game.robots) {
                    if (((x - 1) == r.getX()) && (y == r.getY())) {
                        if(checkForWall(r, -1, 0)) {
                        } else { r.setPosition(r.getX() - 1, r.getY()); }
                        return true;
                    }
                }
                break;
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
        int y = 2;
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
        float xStart = 883;
        float yStart = 680;

        // 83 y 17

        for (PlayingCard kort : cards) {
            int priority = kort.getPriority();
            priorityfont.draw(batch, Integer.toString(priority), xStart , yStart);
            xStart += 93;

            if(xStart == 1348) {
                xStart = 930;
                yStart = 520;
            }
        }
        xStart = 883;
        yStart = 252;
        for (PlayingCard locked : lockedHand) {
            int priority = locked.getPriority();
            priorityfont.draw(batch, Integer.toString(priority), xStart , yStart);
            xStart += 92;
        }
    }

    public void initializeHud(Batch batch){
        hudFont.draw(batch, ("Player: " + id), 30, 80);
        hudFont.draw(batch, ("HP = " + robotHealthPoint), 715, 80);
        hudFont.draw(batch, ("Flag to take = " + flagToTake), 30, 30);
        hudFont.draw(batch, ("Lives = " + lives), 700, 30);

    }

    public void renderHud(String text, SpriteBatch batch, int hudPosition){
        BitmapFont hudFont = new BitmapFont(Gdx.files.internal("fonts/17green.fnt"));
        batch.begin();
        if(hudPosition == 0){ hudFont.draw(batch, text, 500, 55); }
        else{ hudFont.draw(batch, text, 1000,55); }
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


    public void move(int steps) {

        int moveby;
        if (steps < 0) {
            moveby = -1;
        } else {
            moveby = 1;
        }

        int robotRotation = (int) this.getRotation();
/**
        if(moveby != 1) {
            robotRotation += 180;
            if (robotRotation == 360) {
                robotRotation = 0;
            }
        }
*/
        System.out.println("MOVEBY = " + moveby);
        //System.out.println("FAKTISK ROTATION ROBOT = " + this.getRotation() + " JUKSEROTATION = " + robotRotation);
        switch ((int) robotRotation) {
            case(0): // robot oppreist -- peker mot sør
                for(int i = 1; i <= Math.abs(steps); i++){
                        if(moveby == 1 && checkForWall(this, 0, -1)){
                            System.out.println("11111");
                        }
                        else if((moveby == -1 && checkForWall(this, 0, 1))) {
                            System.out.println("22222");
                        }
                        else if (checkForPlayer((int)this.getRotation()) && (moveby == 1)) {
                            System.out.println("Other robot in front of player");
                            this.setPosition(this.getX(), this.getY() - moveby);
                        }
                        else if (checkForPlayer(180)) {
                            this.setPosition(this.getX(), this.getY() - moveby);
                        }
                        else{ this.setPosition(this.getX(), this.getY() - moveby); }

                }
                break;

            case(90):
                for(int i = 1; i <= Math.abs(steps); i++){
                    if(checkForWall(this, 1, 0)){
                        //System.out.println("WALL IN FRONT");
                    }
                    else if (checkForPlayer((int) this.getRotation()) && (moveby > 0)) {
                        System.out.println("Other robot in front of player");
                        this.setPosition(this.getX() + moveby, this.getY());
                        }
                    else if (checkForPlayer(270)) {
                        this.setPosition(this.getX() + moveby, this.getY());
                    }
                    else { this.setPosition(this.getX() + moveby, this.getY()); }
                    }
                break;

            case(180):
                for(int i = 1; i <= Math.abs(steps); i++){
                    if(checkForWall(this, 0, 1)){
                        //System.out.println("WALL IN FRONT");
                    }
                    else if (checkForPlayer((int) this.getRotation()) && (moveby > 0)) {
                        System.out.println("Other robot in front of player");
                        this.setPosition(this.getX(), this.getY() + moveby);
                    }
                    else if (checkForPlayer(0)) {
                        this.setPosition(this.getX(), this.getY() + moveby);
                    }
                    else { this.setPosition(this.getX(), this.getY() + moveby); }
                }
                break;

            case(270):
                for(int i = 1; i <= Math.abs(steps); i++){
                    if(checkForWall(this, -1, 0)){
                        //System.out.println("WALL IN FRONT");
                    }
                    else if (checkForPlayer((int) this.getRotation()) && (moveby > 0)) {
                        System.out.println("Other robot in front of player");
                        this.setPosition(this.getX() - moveby, this.getY());
                    }
                    else if (checkForPlayer(90)) {
                        this.setPosition(this.getX() - moveby, this.getY());
                    }
                    else { this.setPosition(this.getX() - moveby, this.getY()); }
                }
                break;

        }
    }
    public boolean checkForWall(Robot player, int xDiff, int yDiff){
        for (Wall wall : game.allWalls){
            if(wall.isWallInSameTileInFrontOfPlayer(player, xDiff, yDiff) || wall.IsWallInNextTileInFrontOfPlayer(player, xDiff, yDiff)) {
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

    public void respawn() {
        this.robotHealthPoint = 9;
        this.lives -= 1;
        this.setPosition(checkpoint.x, checkpoint.y);
    }

}

