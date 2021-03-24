package inf112.skeleton.app.map;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.object.Robot;
import inf112.skeleton.app.map.Laser;

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



    public Wall(Vector2 wallPos, TiledMapTileLayer.Cell cell, int cellId){
        this.wallPos = wallPos;
        this.cell = cell;
        this.cellId = cellId;

        //rightWall = new HashMap<Integer, Integer>();
        //wallLayer.getCell(1,1).getTile().getId();
    }

    public Boolean isWallInFrontOfPlayer(Robot player, float x, float y){

        float rotation = player.getRotation();
        Vector2 playerCoordinate = new Vector2(x, y);
        if (playerCoordinate.equals(wallPos) && ((cellId == SOUTH) || (cellId == Laser.laserSOUTH)) && rotation == 0) {
            System.out.println("Wall facing SOUTH");
            return true; }

        else if (playerCoordinate.equals(wallPos) && ((cellId == EAST) || (cellId == Laser.laserEAST) || (cellId == Laser.doubleLaserEAST)) && rotation == 90) {
            System.out.println("Wall facing EAST");
            return true; }

        else if(playerCoordinate.equals(wallPos) && (cellId == NORTH) && rotation == 180) {
            System.out.println("Wall facing NORTH");
            return true; }

        else if (playerCoordinate.equals(wallPos) && ((cellId == WEST) || (cellId == Laser.laserWEST)) && rotation == 270) {
            System.out.println("Wall facing WEST");
            return true; }

        else return false;
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
