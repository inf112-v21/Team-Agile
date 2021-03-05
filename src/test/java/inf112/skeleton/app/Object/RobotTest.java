package inf112.skeleton.app.Object;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    TiledMapTileLayer playerLayer;
    Robot player;
    Vector2 pos;
    InputHandler handler;

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

        /*oppsett av variabler som trengs for testene.
        TiledMapTileLayer for å skjekke om spiller objektet eksisterer på nåværende celle, og forsvinner fra den cellen
        når en bevegelse utføres.

        Robot klassen som skal testes med bevegelse funksjon.
         */

        playerLayer = new TiledMapTileLayer(5,5,300,300);
        pos = new Vector2(1,1);
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();

        player = new Robot(new TextureRegion(new Texture("pikachu.png")) , 3 , 3);
        playerLayer.setCell((int) player.getX(), (int) player.getY(), cell);
    }



    @Test
    public void GivenTakesTheLastFlagThenWins() {
        Integer flagsToTake = 3;

        player.visitFlag(1);
        player.visitFlag(2);

        //Sjekker om flagget som skal tas er det samme som siste flagget
        assertEquals(flagsToTake, player.getFlag());
    }

    @Test
    public void keyRightShouldMakePlayerMoveOneToTheRightDirection() {

        //sjekker at player befinner seg på en celle.
        assertNotNull(playerLayer.getCell((int) player.getX(), (int) player.getY()));

        //sjekker om nye posisjon til player er lik posisjon som er forventet ved tastetrykk.
        Vector2 newPosition = new Vector2((int) player.getX() + 1, (int) player.getY());
        handler = new InputHandler(player);
        handler.keyUp(Input.Keys.RIGHT);

        Float degreesAfter = player.getRotation();

        degreesBefore = degreesBefore + 270;

        assertEquals(degreesBefore, degreesAfter);

    }
    @Test
    public void keyLeftShouldMakePlayerMoveOneToTheLeftDirection() {

        assertNotNull(playerLayer.getCell((int) player.getX(), (int) player.getY()));

        Vector2 newPosition = new Vector2((int) player.getX() - 1, (int) player.getY());
        handler = new InputHandler(player);
        handler.keyUp(Input.Keys.LEFT);

        Float degreesAfter = player.getRotation();

        degreesBefore = degreesBefore + 90;
        assertEquals(degreesBefore, degreesAfter);
    }

    @Test
    public void keyDownShouldMakePlayerMoveOneToTheDownDirection() {

        //Siden spilleren sin robot peker mot sør vil key down gjøre at roboten
        //går 1 i y-retning, selv om det er litt lite intuitivt. Det samme
        //gjelder for keyUp-testen, sånn at den også blir "motsatt".

        assertNotNull(playerLayer.getCell((int) player.getX(), (int) player.getY()));

        Vector2 newPosition = new Vector2((int) player.getX(), (int) player.getY() - 1);
        handler = new InputHandler(player);
        handler.keyUp(Input.Keys.DOWN);
        Vector2 currentPosition = new Vector2((int) player.getX() + 1, (int) player.getY());

        assertEquals(newPosition, currentPosition);

        assertNull(playerLayer.getCell((int) player.getX(), (int) player.getY()));
    }

    @Test
    public void keyUpShouldMakePlayerMoveOneToTheUpDirection() {

        assertNotNull(playerLayer.getCell((int) player.getX(), (int) player.getY()));

        Vector2 newPosition = new Vector2((int) player.getX(), (int) player.getY() + 1);
        handler = new InputHandler(player);
        handler.keyUp(Input.Keys.UP);
        Vector2 currentPosition = new Vector2((int) player.getX() + 1, (int) player.getY());

        assertEquals(newPosition, currentPosition);

        assertNull(playerLayer.getCell((int) player.getX(), (int) player.getY()));
    }

}
