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
                move(1);
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
                player.rotate90(false);
                break;
        }
        return false;
    }

    private void move(int x, int y, int rotation) {
        player.setPosition(player.getX() + x , player.getY() + y);
        player.setRotation(rotation);

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
