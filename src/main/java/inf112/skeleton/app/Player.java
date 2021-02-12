package inf112.skeleton.app;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Player extends InputAdapter {

    Vector2 position;
    TiledMapTileLayer playerLayer;

    int totalFlags = 3;
    int flagToTake = 1;


    ArrayList<FlagID> flagsvisited = new ArrayList<FlagID>();

    public Player(Vector2 playerpos, TiledMapTileLayer playerTileLayer) {
        this.position = playerpos;
        this.playerLayer = playerTileLayer;
        int totalFlags;
        int flagTotake;

    }

    private void move(int deltaX, int deltaY) {
        playerLayer.setCell((int) position.x, (int) position.y, null);
        position.set(position.x + deltaX, position.y + deltaY);

    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                move(-1, 0);
                break;
            case Input.Keys.RIGHT:
                move(1, 0);

                break;
            case Input.Keys.UP:
                move(0, 1);
                break;
            case Input.Keys.DOWN:
                move(0, -1);
                break;
        }
        return false;
    }


    public float getPositionX() {
        return position.x;
    }

    public float getPositionY() {
        return position.y;
    }

    public void visitFlag(int flagID) {
        if (flagID > flagToTake) {
            return;
        }
        if (flagID == flagToTake) {
            flagToTake += 1;
            System.out.println("flag:" + flagID + " was taken");
            System.out.println(flagToTake);
        }

    }

}


