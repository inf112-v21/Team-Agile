package inf112.skeleton.app.map;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.object.Robot;

import java.util.HashMap;
public class Wall {

    TiledMapTileLayer.Cell cell;
    HashMap rightWall;
    Integer wallID;
    Vector2 wallPos;
    int cellId;

    // wall values from .tmx-file:
    int SOUTH = 29;
    int WEST = 30;
    int NORTH = 31;
    int EAST = 23;

    int laserSOUTH = 37;
    int laserWEST = 38;
    //int laserNORTH = ;
    int laserEAST = 46;

    int doubleLaserEAST = 95;

    public Wall(Vector2 wallPos, TiledMapTileLayer.Cell cell, int cellId){
        this.wallPos = wallPos;
        this.cell = cell;
        this.cellId = cellId;

        //rightWall = new HashMap<Integer, Integer>();
        //wallLayer.getCell(1,1).getTile().getId();
    }

    public Boolean isWallInFrontOfPlayer(Robot player, float x, float y){

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

/**
 * 23 = vegg i ØST
 * 30 = vegg i VEST
 * 31 = vegg i NORD
 * 29 = vegg i SØR
 *
 * 37 = laser fra SØR mot NORD
 * 38 = laser fra VEST mot ØST
 * 46 = laser fra ØST mot VEST
 *
 * 95 = dobbel laser fra ØST mot VEST
 */
