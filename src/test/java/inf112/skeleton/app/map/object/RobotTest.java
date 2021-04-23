package inf112.skeleton.app.map.object;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    TiledMapTileLayer playerLayer;
    Robot player, player2;
    Robot testPlayer;
    Vector2 pos;
    InputHandler handler;

    RoboRally game = new RoboRally("tutorial.tmx", true);

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
        /**
        oppsett av variabler som trengs for testene.
        TiledMapTileLayer for å skjekke om spiller objektet eksisterer på nåværende celle, og forsvinner fra den cellen
        når en bevegelse utføres.

        Robot klassen som skal testes med bevegelse funksjon. Roboten starter med retning mot Øst , ettersom det er det
        den skal i forhold til spillkartet.
        */

        playerLayer = new TiledMapTileLayer(5,5,300,300);
        pos = new Vector2(1,1);
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();

        player = new Robot(3,3, Color.BLACK, 1, game);
        playerLayer.setCell((int) player.getX(), (int) player.getY(), cell);




    }




    @Test
    public void keyRightShouldMakePlayerRotate90DegreesToRight() {

        //sjekker at player befinner seg på en celle.
        assertNotNull(playerLayer.getCell((int) player.getX(), (int) player.getY()));

        player.rotate(-90);

        assertEquals(0, (int) player.getRotation());



    }
    @Test
    public void keyLeftShouldMakePlayerRotate90DegreesToLeft() {

        assertNotNull(playerLayer.getCell((int) player.getX(), (int) player.getY()));

        Float degreesBefore = player.getRotation();

        player.rotate(90);
        Float degreesAfter = player.getRotation();

        degreesBefore = degreesBefore + 90;
        assertEquals(degreesBefore, degreesAfter);
    }


    @Test
    public void robotVisitSecondFlagWithoutVisitingFirstFlagFirst() {
        player.visitFlag(2);

        assertEquals(1, (int) player.getFlag());
    }
    @Test
    public void robotVisitThirdFlagWithoutVisitingSecondFlagFirst() {
        player.visitFlag(1);
        player.visitFlag(3);

        assertEquals(2, (int) player.getFlag());
    }

    @Test
    public void robotVisitFirstFlag() {
        player.visitFlag(1);

        assertEquals(2, (int) player.getFlag());
    }
    @Test
    public void robotVisitFirstFlagAndSecondFlag() {
        player.visitFlag(1);
        player.visitFlag(2);

        assertEquals(3, (int) player.getFlag());
    }
    @Test
    public void robotVisitFirstFlagAndSecondFlagAndThirdFlag() {
        player.visitFlag(1);
        player.visitFlag(2);
        player.visitFlag(3);

        //når FlagToTake er 4 da har spilleren vunnet.
        assertEquals(4, (int) player.getFlag());

    }


}
