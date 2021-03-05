package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Flag {
    TiledMapTileLayer flagLayer;
    Integer flagID;

    Vector2 position;


    public Flag(TiledMapTileLayer flagLayer, Integer flagID, Vector2 flagpos, float xPos, float yPos) {
        this.flagLayer = flagLayer;
        this.flagID = flagID;

        this.position = flagpos;

        flagLayer.setCell((int) position.x, (int) position.y, null );
        position.set(position.x + xPos, position.y + yPos);
    }

    public Flag(Vector2 flagpos, Integer flagID) {
        this.position = flagpos;
        this.flagID = flagID;
    }

}

