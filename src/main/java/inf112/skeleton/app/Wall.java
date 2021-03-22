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

    public enum Type {
        SOUTH,
        WEST,
        NORTH,
        EAST
    }

    public Wall(TiledMapTileLayer wallLayer, Vector2 wallPos, Integer wallID, RotationDirection direction){

        //første hente layer
        this.wallLayer = wallLayer;



        rightWall = new HashMap<Integer, Integer>();


        wallLayer.getCell(1,1).getTile().getId();
    }

    public Boolean isWallInFrontOfPlayer(Robot player){

        float rotation = player.getRotation();
        xycoord playercoords = new xycoord();
        playercoords.setX(player.getX());
        playercoords.setY(player.getY());

        //HashMap<playercoords, RotationDirection>


        switch(rotation) {
            case 0:
                if (RoboRally.walls.get(playercoords) == RotationDirection.SOUTH) {
                    return true;
            } case 90:
                if (RoboRally.walls.get(playercoords) == RotationDirection.WEST) {
                    return true;
                } case 180:
                if (RoboRally.walls.get(playercoords) == RotationDirection.NORTH) {
                    return true;
                } case 270:
                if (RoboRally.walls.get(playercoords) == RotationDirection.EAST) {
                    return true;
                }
        }
        return false;
    }

}

