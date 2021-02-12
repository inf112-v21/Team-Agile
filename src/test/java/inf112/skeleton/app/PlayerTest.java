package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Player;
import org.junit.Before;
import org.junit.Test;

import org.junit.api.Assertions.*;

public class PlayerTest {

    TiledMap board;
    TiledMapTileLayer playerLayer;
    Player player;
    private Object assertEquals;

    @Before
    public void setup() {
        TmxMapLoader loader = new TmxMapLoader();
        playerLayer = new TiledMapTileLayer(5,5,300,300);
        Vector2 pos = new Vector2();
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();

        player = new Player(pos, playerLayer);

        playerLayer.setCell((int) player.getPositionX(), (int) player.getPositionY(), cell);


    }

    @Test
    public void keyRightShouldMakePlayerMoveOneToTheRightDirection() {

        assertNotNull(playerLayer.getCell((int) player.getPositionX(), (int) player.getPositionY()));



   }
}
