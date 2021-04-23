package inf112.skeleton.app.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.map.object.Robot;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class SingleBoosterTest {

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
/*
    @BeforeEach
    public void setUpRobot() throws Exception {
        robot = new Robot(5,8, Color.BLACK,1,game);
        game.robots.add(robot);

        //game.robots.remove(robot);

    }

 */


    @Test
    public void testSingleBoosterWestDirection(){
        /*
        robot = new Robot(5,8, Color.BLACK,1,game);
        game.robots.add(robot);

         */
        robot.setPosition(5,8);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(4, (int) robot.getX());
        assertEquals(8, (int) robot.getY());
    }

    @Test
    public void testSingleBoosterEastDirection(){
        /*
        robot = new Robot(9,9, Color.BLACK,1,game);
        game.robots.add(robot);

         */
        robot.setPosition(9,9);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(10, (int) robot.getX());
        assertEquals(9, (int) robot.getY());
    }

    @Test
    public void testSingleBoosterNorthDirection(){
        /*
        robot = new Robot(7,2, Color.BLACK,1,game);
        game.robots.add(robot);

         */
        robot.setPosition(7,2);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(7, (int) robot.getX());
        assertEquals(3, (int) robot.getY());
    }

    @Test
    public void testSingleBoosterSouthDirection(){
        /*
        robot = new Robot(5,6, Color.BLACK,1,game);
        game.robots.add(robot);

         */
        robot.setPosition(5,6);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(5, (int) robot.getX());
        assertEquals(5, (int) robot.getY());
    }

    @Test
    public void testSingleTurnLeftDown() {
        robot = new Robot(10, 8, Color.BLACK, 1, game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(10, (int) robot.getX());
        assertEquals(7, (int) robot.getY());
        assertEquals(180, (int) robot.getRotation());

    }

    @Test
    public void testSingleTurnRightDown() {
        robot = new Robot(5, 7, Color.BLACK, 1, game);
        game.robots.add(robot);
        game.checkevent.checkBoosters(game.robots);
        assertEquals(5, (int) robot.getX());
        assertEquals(6, (int) robot.getY());
        assertEquals(0, (int) robot.getRotation());

    }
}
