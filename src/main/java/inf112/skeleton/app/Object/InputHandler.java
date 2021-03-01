package inf112.skeleton.app.Object;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputHandler extends InputAdapter {

    Robot player;

    int dir = 0;

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
                move(-1);
                break;
            case Input.Keys.LEFT:
                rotate(90);
                break;
            case Input.Keys.RIGHT:
                rotate(-90);
                break;
            case Input.Keys.R:
                rotate(180);
                break;
        }
        return false;
    }

    private void move(int x, int y, int rotation) {
        player.setPosition(player.getX() + x , player.getY() + y);
        player.setRotation(rotation);

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

    private void rotate(int degree) {
        player.setRotation(player.getRotation() + degree);
        resetDegrees((int) player.getRotation());
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
