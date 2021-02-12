package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Flag {

    Vector2 flagPosition;
    TiledMapTileLayer flagLayer;
    int flagID;

    public float getFlagPositionX() {
        return flagPosition.x;
    }

    public float getFlagPositionY() {
        return flagPosition.y;
    }

    public Flag(Vector2 flagPos, TiledMapTileLayer flagTileLayer) {
        this.flagPosition = flagPos;
        this.flagLayer = flagTileLayer;

    }

    public void visitedFlag () {

    }


}

