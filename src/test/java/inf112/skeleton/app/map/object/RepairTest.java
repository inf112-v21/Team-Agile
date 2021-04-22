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

public class RepairTest {
    Robot robot, robot2;
    RoboRally game = new RoboRally("MapNumber1.tmx" , true);
    ArrayList<Robot> robots = new ArrayList();

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

        robot2 = new Robot(6,4, Color.BLACK, 1, game);  // placing robot on position on two-health repair tile
        robots.add(robot2);

    }

    @Test
    public void testRepairOneHealthTile(){
        robot.setRobotHealthPoint(2);
        game.checkevent.checkRepair(robots);

        // check if robot have gained one health
        assertEquals(3, robot.getRobotHealthPoint());
    }

    @Test
    public void testRepairTwoHealthTile(){
        robot2.setRobotHealthPoint(2);
        game.checkevent.checkRepair(robots);

        // check if robot have gained two health
        assertEquals(4, robot2.getRobotHealthPoint());
    }

    @Test
    public void testRepairOneHealthTileWhenRobotsHealthIsFull(){
        robot.setRobotHealthPoint(9);
        game.checkevent.checkRepair(robots);

        // check if robot not have gained any gealg
        assertEquals(9, robot.getRobotHealthPoint());
    }

    @Test
    public void testRepairTwoHealthTileWhenRobotsHealthIsFull(){
        robot2.setRobotHealthPoint(9);
        game.checkevent.checkRepair(robots);

        // check if robot not have gained any gealg
        assertEquals(9, robot2.getRobotHealthPoint());
    }

    @Test
    public void testRepairTwoHealthTileWhenRobotsHealthIs8(){
        robot2.setRobotHealthPoint(8);
        game.checkevent.checkRepair(robots);

        // check if robot have gained one health
        assertEquals(9, robot2.getRobotHealthPoint());
    }

}