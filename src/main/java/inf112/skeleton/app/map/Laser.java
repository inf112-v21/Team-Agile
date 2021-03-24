package inf112.skeleton.app.map;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.object.Robot;

import java.util.HashMap;

public class Laser extends Wall {

    TiledMapTileLayer.Cell cell;
    Integer wallID;
    Vector2 wallPos;
    int cellId;

    int laserSOUTH = 37;
    int laserWEST = 38;
    //int laserNORTH = ;
    int laserEAST = 46;

    int doubleLaserEAST = 95;


    public Laser(Vector2 wallPos, TiledMapTileLayer.Cell cell, int cellId) {
        super(wallPos, cell, cellId);
    }

    public Boolean isLaserInFrontOfPlayer(Robot player, float x, float y){

        float rotation = player.getRotation();
        //Vector2 playerCoordinate = new Vector2(player.getX(), player.getY());
        Vector2 playerCoordinate = new Vector2(x, y);
        switch((int) rotation) {
            case 0:
                if (playerCoordinate.equals(wallPos) && (cellId == SOUTH)) {
                    System.out.println("Wall facing SOUTH");
                    return true;

                } case 90:
                if (playerCoordinate.equals(wallPos) && (cellId == WEST)) {
                    System.out.println("Wall facing WEST");
                    return true;

                } case 180:
                if (playerCoordinate.equals(wallPos) && (cellId == NORTH)) {
                    System.out.println("Wall facing NORTH");
                    return true;

                } case 270:
                if (playerCoordinate.equals(wallPos) && (cellId == EAST)) {
                    System.out.println("Wall facing EAST");
                    return true;
                }
        }
        return false;
    }
}
