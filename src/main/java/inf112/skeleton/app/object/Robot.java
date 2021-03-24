package inf112.skeleton.app.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.skeleton.app.cards.PlayingCard;

import java.util.ArrayList;

public class Robot extends Sprite {

    private final int WIDTH = 1;
    private final int HEIGHT = 1;

    public int robotHealthPoint;

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

    BitmapFont priorityfont = new BitmapFont(Gdx.files.internal("fonts/17green.fnt"));
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

    public Robot(int xstart, int ystart, Color color, int id) {
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

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }


    public void playerCardstoHand(ArrayList<PlayingCard> spillerkort) {
        int x = 14;
        int y = 10;
        for (int i = 0; i < spillerkort.size() ; i++ ) {
            PlayingCard nvKort = spillerkort.get(i);
            nvKort.setPosition( x,  y);
            x += 2;
            if(x == 24 ) {
                x = 15;
                y = 7;
            }
        }
    }

    public void playerLocked(ArrayList<PlayingCard> lockedkort) {
        int x = 14;
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
        float xStart = 808f;
        float yStart = 682f;

        for (PlayingCard kort : cards) {
            int priority = kort.getPriority();
            priorityfont.draw(batch, Integer.toString(priority), xStart , yStart);
            xStart += 107;

            if(xStart == 1343) {
                xStart = 864;
                yStart = 520;
            }
        }
        xStart = 808f;
        yStart = 307;
        for (PlayingCard locked : lockedHand) {
            int priority = locked.getPriority();
            priorityfont.draw(batch, Integer.toString(priority), xStart , yStart);
            xStart += 107;
        }
    }

    public void initializeHud(Batch batch){
        hudFont.draw(batch, ("Player: " + id), 30, 80);
        hudFont.draw(batch, ("HP = " + robotHealthPoint), 615, 80);
    }

    public void renderHud(String text, SpriteBatch batch, int hudPosition){
        BitmapFont hudFont = new BitmapFont(Gdx.files.internal("fonts/17green.fnt"));
        batch.begin();
        if(hudPosition == 0){ hudFont.draw(batch, text, 250, 55); }
        else{ hudFont.draw(batch, text, 901,55); }
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

