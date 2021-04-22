package inf112.skeleton.app.map.object;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import inf112.skeleton.app.RoboRally;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotationTest {
    Robot robot;
    RoboRally game = new RoboRally("MapNumber1.tmx" , true);

    @Before
    public void setUp() throws Exception {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("CLOSE THIS WINDOW TO START THE TESTS");
        cfg.setWindowedMode(500, 100);
        new Lwjgl3Application(new Game() {
            @Override
            public void create() {
                game.show();
                Gdx.app.exit();
            }
        }, cfg);
    }

    @Test
    public void testRotationLeftTile(){
        robot = new Robot(6,7, Color.BLACK, 1, game); // placing robot on position with rotation-tile
        game.robots.add(robot);
        robot.setRotation(0);
        game.checkevent.checkRotate(game.robots);

        // check if robot have rotated towards left.
        assertEquals(90, (int) robot.getRotation());
    }

    @Test
    public void testRotationRightTile(){
        robot = new Robot(6,8, Color.BLACK, 1, game); // placing robot on position with rotation-tile
        game.robots.add(robot);
        robot.setRotation(0);
        game.checkevent.checkRotate(game.robots);

        // check if robot have rotated towards left.
        assertEquals(270, (int) robot.getRotation());
    }
}