package inf112.skeleton.app.map;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.object.Robot;

import java.util.HashMap;
public class Wall {

    TiledMapTileLayer wallLayer;
    HashMap rightWall;
    Integer wallID;
    Vector2 wallPos;


    public enum Type {
        SOUTH,
        WEST,
        NORTH,
        EAST
    }

    public Wall(TiledMapTileLayer wallLayer, Integer wallID, Vector2 wallPos){
        this.wallLayer = wallLayer;
        this.wallID = wallID;
        this.wallPos = wallPos;
        rightWall = new HashMap<Integer, Integer>();

        wallLayer.getCell(1,1).getTile().getId();
    }

    public Boolean isWallInFrontOfPlayer(Robot player){

        float rotation = player.getRotation();
        xyCoordinate playerCoordinate = new xyCoordinate(player.getX(), player.getY());

        switch((int) rotation) {
            case 0:
                if (RoboRally.walls.get(playerCoordinate) == RotationDirection.SOUTH) {
                    return true;
            } case 90:
                if (RoboRally.walls.get(playerCoordinate) == RotationDirection.WEST) {
                    return true;
                } case 180:
                if (RoboRally.walls.get(playerCoordinate) == RotationDirection.NORTH) {
                    return true;
                } case 270:
                if (RoboRally.walls.get(playerCoordinate) == RotationDirection.EAST) {
                    return true;
                }
        }
        return false;
    }


}

