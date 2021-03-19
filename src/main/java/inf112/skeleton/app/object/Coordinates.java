package inf112.skeleton.app.object;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Coordinates {
    TiledMapTileLayer coords;


    public Coordinates(){

        for(int i = 0; i <= coords.getHeight(); i++){
            for(int j = 0; j <= coords.getWidth(); j++){
                coords.getCell(i,j);

            }


        }
    }
}
