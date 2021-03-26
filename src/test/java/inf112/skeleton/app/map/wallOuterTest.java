package inf112.skeleton.app.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.object.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class wallOuterTest {

    Robot robot1, robot2;
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

    }


    public void setUpNewWallInGameOuterBorders(){ // Til å sette opp vegger opp i brettets ytre vegger
        robot1 = new Robot(0,2, Color.BLACK,1, game); // setter robot opp i nedre venstre hjørne
        robot2 = new Robot(16,13, Color.BLACK,1, game); // setter robot opp i øvre høgre hjørne
    }

    @Test
    public void testIfWallIsCreatedInGameMapBordersNorth(){
        setUpNewWallInGameOuterBorders(); // setter opp ytre vegger
        robot2.setRotation(180);
        robot2.move(1);

        assertEquals(16, (int) robot2.getX());
        assertEquals(13, (int) robot2.getY());
    }
    @Test
    public void testIfWallIsCreatedInGameMapBordersSouth(){
        setUpNewWallInGameOuterBorders();
        robot1.setRotation(0);
        robot1.move(1);

        assertEquals(0, (int) robot1.getX());
        assertEquals(2, (int) robot1.getY());
    }
    @Test
    public void testIfWallIsCreatedInGameMapBordersWest(){
        setUpNewWallInGameOuterBorders();
        robot1.setRotation(270);
        robot1.move(1);

        assertEquals(0, (int) robot1.getX());
        assertEquals(2, (int) robot1.getY());
    }
    @Test
    public void testIfWallIsCreatedInGameMapBordersEast(){
        setUpNewWallInGameOuterBorders();
        robot2.setRotation(90);
        robot2.move(1);

        assertEquals(16, (int) robot2.getX());
        assertEquals(13, (int) robot2.getY());
    }
}
