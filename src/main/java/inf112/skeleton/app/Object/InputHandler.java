package inf112.skeleton.app.Object;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputHandler extends InputAdapter {

    Robot player;

    public InputHandler(Robot player) {
        this.player = player;
    }


    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                move(0, 1, 180);
                break;
            case Input.Keys.DOWN:
                move(0, -1, 0);
                break;
            case Input.Keys.LEFT:
                move(-1, 0 , 270);
                break;
            case Input.Keys.RIGHT:
                move(1, 0, 90);
                break;
            case Input.Keys.R:
                player.setRotation(player.getRotation() + 90);
                break;
        }
        return false;
    }

    private void move(int x, int y, int rotation) {
        player.setPosition(player.getX() + x , player.getY() + y);
        player.setRotation(rotation);

    }

}
