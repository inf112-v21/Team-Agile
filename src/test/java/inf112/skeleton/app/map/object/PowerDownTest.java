package inf112.skeleton.app.map.object;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import inf112.skeleton.app.RoboRally;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PowerDownTest {
    Robot robot;
    RoboRally game = new RoboRally("MapNumber1.tmx" , true);
    ArrayList<Robot> robots = new ArrayList();
    int healthBefore;
    int healthAfter;
    InputHandler handler;

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

        robot = new Robot(4,13, Color.BLACK, 1, game);  // placing robot on position on one-health repair tile
        robots.add(robot);
        handler = new InputHandler(game, robot);

    }

    @Test
    public void testThatPowerDownRestoresFullHealth() {
         robot.setRobotHealthPoint(2);
         int startHp = robot.robotHealthPoint;
         handler.powerDown();
         int endHp = robot.robotHealthPoint;
         assertEquals(9, endHp);

    }

    @Test
    public void testThatPowerDownKeepsPlayerPosition(){

    }

    @Test
    public void testThatPowerDownMakesPlayerUnavailableForOneCycle(){

    }


}
