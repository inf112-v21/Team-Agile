package inf112.skeleton.app.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.object.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoosterTest {

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
    public void testSingleBoosterWestDirection(){
        robot = new Robot(5,8, Color.BLACK,1,game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(4, (int) robot.getX());
        assertEquals(8, (int) robot.getY());

    }

    @Test
    public void testSingleBoosterEastDirection(){
        robot = new Robot(9,9, Color.BLACK,1,game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(10, (int) robot.getX());
        assertEquals(9, (int) robot.getY());
    }

    @Test
    public void testSingleBoosterNorthDirection(){
        robot = new Robot(7,2, Color.BLACK,1,game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(7, (int) robot.getX());
        assertEquals(3, (int) robot.getY());
    }

    @Test
    public void testSingleBoosterSouthDirection(){
        robot = new Robot(5,6, Color.BLACK,1,game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(5, (int) robot.getX());
        assertEquals(5, (int) robot.getY());
    }


    @Test
    public void testDoubleBoosterNorthDirection(){
        robot = new Robot(7,6, Color.BLACK,1,game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(5, (int) robot.getX());
        assertEquals(5, (int) robot.getY());
    }
    @Test
    public void testDoubleBoosterSouthDirection(){
        robot = new Robot(9,13, Color.BLACK,1,game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(5, (int) robot.getX());
        assertEquals(5, (int) robot.getY());
    }

    @Test
    public void testDoubleBoosterWestDirection(){
        robot = new Robot(8,11, Color.BLACK,1,game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(5, (int) robot.getX());
        assertEquals(5, (int) robot.getY());
    }
}
