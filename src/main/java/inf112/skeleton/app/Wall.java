package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Wall {

    TiledMapTileLayer wallLayer;
    HashMap wallInput, rightWall, upperWall;
    Integer ID;

    int posX;
    int posY;



    public Wall(TiledMapTileLayer wallLayer, Vector2 wallPos, Integer wallID){

        //første hente layer
        this.wallLayer = wallLayer;

        rightWall = new HashMap<Integer, Integer>();


        wallLayer.getCell(1,1).getTile().getId();
    }


}