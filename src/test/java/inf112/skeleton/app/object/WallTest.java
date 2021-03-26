package inf112.skeleton.app.object;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.map.Wall;
import inf112.skeleton.app.object.Robot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WallTest {


    Wall wall;
    Vector2 wallPos;
    int cellID;
    Robot robot;
    RoboRally game = new RoboRally("tutorial.tmx");


    @Before
    public void setUp() throws Exception {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("CLOSE THIS WINDOW TO START THE TESTS");
        cfg.setWindowedMode(500, 100);
        new Lwjgl3Application(new Game() {
            @Override
            public void create() {
                Gdx.app.exit();
            }
        }, cfg);

        robot = new Robot(3,3, Color.BLACK,1,game);
        robot.setRotation(0);
        wall = new Wall(new Vector2(3,3), 29 );
        game.allWalls.add(wall);
        robot.move(1);
    }

    @Test
    public void testIfWallIsInFrontOfPlayerSouth(){
         assertEquals(3, (int) robot.getX());
         assertEquals(3, (int) robot.getY());
    }

    @Test
    public void testIfWallIsInFrontOfPlayerNorth(){
        assertEquals(3, (int) robot.getX());
        assertEquals(3, (int) robot.getY());
    }



}
