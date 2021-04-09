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
import static org.junit.Assert.assertNotEquals;

public class LaserTest {

    Laser laser, laser1, laser2;
    Robot robot, robot2, robot3, robot4, robot5;
    RoboRally game = new RoboRally("MapNumber1.tmx" , true);


    @Before
    public void setUp() throws Exception {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("CLOSE THIS WINDOW TO START THE TESTS");
        cfg.setWindowedMode(500, 100);
        new Lwjgl3Application(new Game() {
            @Override
            public void create() {
                game.create();
                Gdx.app.exit();
            }
        }, cfg);

        robot = new Robot(6,9, Color.BLACK,1,game); // robot som blir truffet av laser
        robot2 = new Robot(6,10, Color.BLACK,1,game); // robot som står i skuddlinjen til laser, men blir ikke truffet da robot1 blokkerer
        robot3 = new Robot(6,13, Color.BLACK,1,game); // robot som er bak veggen som stopper laseren. Skal ikke bli truffet
        robot4 = new Robot(9,5, Color.BLACK,1,game); // robot som blir truffet av dobbel laser

        game.robots.add(robot);
        game.robots.add(robot2);
        game.robots.add(robot3);
        game.robots.add(robot4);

    }

    @Test
    public void GivenRobotInLaserBeamThenRobotGetsHitByLaser() {
        //set up SOUTH laser (shoots towards NORTH)
        //setUpNewLaser(37);

        //health before laser firing
        int healthRobotBeforeHit = robot.getRobotHealthPoint();

        //fire lasers
        game.checkevent.checkLaserBeams(game.allLasers);

        //health after hit by laser
        int healthRobotAfterHit = robot.getRobotHealthPoint();

        //should evaluate to true
        assertNotEquals(healthRobotBeforeHit, healthRobotAfterHit);
    }

    @Test
    public void GivenTwoRobotsInLaserBeamThenOnlyClosestOneGetsHitByLaser() {
        //set up SOUTH laser (shoots towards NORTH)
        //setUpNewLaser(37);

        //health before laser
        int healthRobot1BeforeLaser = robot.getRobotHealthPoint();
        int healthRobot2BeforeLaser = robot2.getRobotHealthPoint();

        //fire lasers
        game.checkevent.checkLaserBeams(game.allLasers);

        //health after laser
        int healthrobot1afterlaser = robot.getRobotHealthPoint();
        int healthrobot2afterlaser = robot2.getRobotHealthPoint();

        //only the assert for robot close to laser should fail (this is intentional)
        assertNotEquals(healthRobot1BeforeLaser, healthrobot1afterlaser);
        assertEquals(healthRobot2BeforeLaser, healthrobot2afterlaser);
    }

    @Test
    public void RobotHitByDoubleLaserShouldTake2InDamage() {
        //set up EAST double laser (shoots towards WEST)
        //setUpNewLaser(95);

        int damage = 2;

        //health before laser firing
        int healthRobotBeforeHit = robot4.getRobotHealthPoint();

        //fire lasers
        game.checkevent.checkLaserBeams(game.allLasers);

        //health after hit by laser
        int healthRobotAfterHit = robot4.getRobotHealthPoint();

        //should evaluate to true
        assertEquals(healthRobotBeforeHit, healthRobotAfterHit+damage);

    }

    @Test
    public void RobotInLineOfLaserButAwayFromBeam() {
        int healthRobotBeforeHit = robot3.getRobotHealthPoint();

        //fire lasers
        game.checkevent.checkLaserBeams(game.allLasers);

        int healthRobotAfterHit = robot3.getRobotHealthPoint();

        //should evaluate to true
        assertEquals(healthRobotBeforeHit, healthRobotAfterHit);
    }
}
