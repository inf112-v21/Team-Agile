package inf112.skeleton.app;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Object.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    TiledMap board;
    TiledMapTileLayer playerLayer;
    Texture texture = new Texture("player.png");
    TextureRegion[][] tr;
    TextureRegion state1;
    Robot player;
    Vector2 pos;


    @Before
    public void setup() {
        /*oppsett av variabler som trengs for testene.
        TiledMapTileLayer for å skjekke om spiller objektet eksisterer på nåværende celle, og forsvinner fra den cellen
        når en bevegelse utføres.

        Robot klassen som skal testes med bevegelse funksjon.


         */

        TmxMapLoader loader = new TmxMapLoader();
        playerLayer = new TiledMapTileLayer(5,5,300,300);
        pos = new Vector2(1,1);
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
        tr = TextureRegion.split(texture, 300, 300);
        state1 = tr[0][0];

        player = new Robot(state1,2,2);

        //playerLayer.setCell((int) player.getPositionX(), (int) player.getPositionY(), cell);
    }

    public void GivenTakesTheLastFlagThenWins() {
        Integer flagsToTake = 2;

        player.visitFlag(1);
        player.visitFlag(2);

        assertEquals(flagsToTake, player.getFlag());
    }
}
