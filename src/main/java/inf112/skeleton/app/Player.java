package inf112.skeleton.app;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends InputAdapter {

    Vector2 position;
    TiledMapTileLayer playerLayer;

    public Player(Vector2 playerpos, TiledMapTileLayer playerTileLayer) {
        this.position = playerpos;
        this.playerLayer = playerTileLayer;
    }
    private void move(int deltaX, int deltaY) {
        playerLayer.setCell((int) position.x, (int) position.y, null );
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
                System.out.print(position.x); // returnere float
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



}
