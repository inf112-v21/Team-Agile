package inf112.skeleton.app;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    TiledMap board;
    TiledMapTileLayer playerLayer;
    Player player;
    Vector2 pos;


    @Before
    public void setup() {
        /*oppsett av variabler som trengs for testene.
        TiledMapTileLayer for å skjekke om spiller objektet eksisterer på nåværende celle, og forsvinner fra den cellen
        når en bevegelse utføres.

        Player klassen som skal testes med bevegelse funksjon.

        */
        TmxMapLoader loader = new TmxMapLoader();
        playerLayer = new TiledMapTileLayer(5,5,300,300);
        pos = new Vector2(1,1);
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();

        player = new Player(pos, playerLayer);

        playerLayer.setCell((int) player.getPositionX(), (int) player.getPositionY(), cell);


    }

    //beskrivelse av tester er lik for all som i første testen.

    @Test
    public void keyRightShouldMakePlayerMoveOneToTheRightDirection() {

        //skjekker at player befinner seg på en celle.
        assertNotNull(playerLayer.getCell((int) player.getPositionX(), (int) player.getPositionY()));

        //skjekker om nye posisjon til player er lik posisjon som er forventet ved tastetrykk.
        Vector2 newPosition = new Vector2((int) player.getPositionX() + 1, (int) player.getPositionY());
        player.keyUp(Input.Keys.RIGHT);
        assertEquals(newPosition, player.position);

        //skjekker om player er fjernet fra den cellen som den opprinnelig befant seg i
        assertNull(playerLayer.getCell((int) player.getPositionX(), (int) player.getPositionY()));




   }
    @Test
    public void keyLeftShouldMakePlayerMoveOneToTheLeftDirection() {

        assertNotNull(playerLayer.getCell((int) player.getPositionX(), (int) player.getPositionY()));

        Vector2 newPosition = new Vector2((int) player.getPositionX() - 1, (int) player.getPositionY());
        player.keyUp(Input.Keys.LEFT);
        assertEquals(newPosition, player.position);

        assertNull(playerLayer.getCell((int) player.getPositionX(), (int) player.getPositionY()));




    }
    @Test
    public void keyDownShouldMakePlayerMoveOneToTheDownDirection() {

        assertNotNull(playerLayer.getCell((int) player.getPositionX(), (int) player.getPositionY()));

        Vector2 newPosition = new Vector2((int) player.getPositionX(), (int) player.getPositionY() - 1);
        player.keyUp(Input.Keys.DOWN);
        assertEquals(newPosition, player.position);

        assertNull(playerLayer.getCell((int) player.getPositionX(), (int) player.getPositionY()));




    }
    @Test
    public void keyUpShouldMakePlayerMoveOneToTheUpDirection() {

        assertNotNull(playerLayer.getCell((int) player.getPositionX(), (int) player.getPositionY()));

        Vector2 newPosition = new Vector2((int) player.getPositionX(), (int) player.getPositionY() + 1);
        player.keyUp(Input.Keys.UP);
        assertEquals(newPosition, player.position);

        assertNull(playerLayer.getCell((int) player.getPositionX(), (int) player.getPositionY()));




    }
}
