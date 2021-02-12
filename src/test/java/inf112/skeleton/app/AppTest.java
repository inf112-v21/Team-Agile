package inf112.skeleton.app;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    //test for bevegelse oppover på bret
    @Test
    public void keyRightShouldMakePlayerMoveOneToTheRightDirection() {

        HelloWorld helloworld = new HelloWorld();





        helloworld.create();

        //private TiledMapTileLayer.Cell playerCell;
        //playerCell = new TiledMapTileLayer.Cell();
        //playerCell.setTile(new StaticTiledMapTile(tr[0][0]));

        helloworld.playerPosition = new Vector2(2,2);

        double oldPosition = helloworld.playerPosition.y;

        helloworld.keyUp(Input.Keys.UP);

        assertTrue(oldPosition + 1 == helloworld.playerPosition.y);
    }


    //spiller går i hull, sjekk render. sjekk om spiller dør dersom samme posisjon som hull
    @Test
    public void checkIfPlayerIsDead(){
    //    assertEquals(playerPosition.get(), hole.get());

    }




}
