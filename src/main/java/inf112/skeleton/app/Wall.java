package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.object.Robot;

import java.util.HashMap;
public class Wall {

    TiledMapTileLayer wallLayer;

    Integer ID;

    HashMap wallInput, rightWall, upperWall;




    int posX;
    int posY;

    public Wall(TiledMapTileLayer wallLayer, Vector2 wallPos, Integer wallID, RotationDirection direction){

        //første hente layer
        this.wallLayer = wallLayer;



        rightWall = new HashMap<Integer, Integer>();


        wallLayer.getCell(1,1).getTile().getId();
    }

    public Boolean isWallInFrontOfPlayer(Robot player){

        float rotation = player.getRotation();

        switch(rotation) {
            case 0:
                if (southWall.get(player.getX(), player.getY()-1) == null) {
                    return false;
            } case 90:
                if (westWall.get(player.getX()-1, player.getY()) == null) {
                    return false;
                } case 180:
                if (northWall.get(player.getX(), player.getY()+1) == null) {
                    return false;
                } case 270:
                if (eastWall.get(player.getX()+1, player.getY()) == null) {
                    return false;
                }
        }

        return true;
    }

}

