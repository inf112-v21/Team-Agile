package inf112.skeleton.app.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.object.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaserTest {

    Laser laser, laser1, laser2;
    Vector2 wallPos;
    int cellID;
    Robot robot, robot2, robot3, robot4, robot5;
    RoboRally game = new RoboRally("tutorial.tmx" , true);

    @BeforeEach
    void setUp() {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("CLOSE THIS WINDOW TO START THE TESTS");
        cfg.setWindowedMode(500, 100);
        new Lwjgl3Application(new Game() {
            @Override
            public void create() {
                Gdx.app.exit();
            }
        }, cfg);
        robot = new Robot(3,4, Color.BLACK,1,game);
        robot2 = new Robot(3,5, Color.BLACK,1,game);
        robot3 = new Robot(4,3, Color.BLACK,1,game);
        robot4 = new Robot(5,3, Color.BLACK,1,game);
    }

    // setter opp laser, og gir mulighet for å bestemme hvilken type laser som skal brukes
    public void setUpNewLaser(int id){
        laser = new Laser(new Vector2(3,3), id);
        laser1 = new Laser(new Vector2(4,3), id);
        laser2 = new Laser(new Vector2(5,3), id); // lager en laser som går fra x = 3, y = 3 til x = 5, y = 3
        game.allLasers.add(laser);

    }

    @Test
    void isLaserInFrontOfPlayer() {
    }

    @Test
    void GivenRobotInLaserBeamThenRobotGetsHitByLaser() {
        //set up SOUTH laser (shoots towards NORTH)
        setUpNewLaser(37);
        int healthrobotbeforehit = robot.getRobotHealthPoint();
        //game.checkLaserBeams(allLasers);
        int healthrobotafterhit = robot.getRobotHealthPoint();

        assertNotEquals(healthrobotbeforehit, healthrobotafterhit);


    }

    @Test
    void GivenTwoRobotsInLaserBeamThenOnlyClosestOneGetsHitByLaser() {
        //set up SOUTH laser (shoots towards NORTH)
        setUpNewLaser(37);

        //health before laser
        int healthrobot1beforelaser = robot.getRobotHealthPoint();
        int healthrobot2beforelaser = robot2.getRobotHealthPoint();

        //fire lasers
        //game.checkLaserBeams(game.allLasers);

        //health after laser
        int healthrobot1afterlaser = robot.getRobotHealthPoint();
        int healthrobot2afterlaser = robot2.getRobotHealthPoint();

        assertEquals(healthrobot1beforelaser, healthrobot1afterlaser);
        assertEquals(healthrobot2beforelaser, healthrobot2afterlaser);
    }
}