package inf112.skeleton.app.map.object;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import inf112.skeleton.app.RoboRally;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleBoosterTest {

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
        robot = new Robot(5,8, Color.BLACK,1,game);
        game.robots.clear();
        game.robots.add(robot);
    }

    @Test
    public void testDoubleTurnDownLeft() {
        robot = new Robot(9, 11, Color.BLACK, 1, game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(7, (int) robot.getX());
        assertEquals(11, (int) robot.getY());
    }

    @Test
    public void testDoubleBoosterNorthDirection(){
        /*
        robot = new Robot(7,6, Color.BLACK,1,game);
        game.robots.add(robot);
        */
        robot.setPosition(7,6);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(7, (int) robot.getX());
        assertEquals(8, (int) robot.getY());
    }
    @Test
    public void testDoubleBoosterSouthDirection(){
        robot = new Robot(9,13, Color.BLACK,1,game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(9, (int) robot.getX());
        assertEquals(11, (int) robot.getY());
    }

    @Test
    public void testDoubleBoosterWestDirection(){
        robot = new Robot(8,11, Color.BLACK,1,game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(6, (int) robot.getX());
        assertEquals(11, (int) robot.getY());
    }

}
