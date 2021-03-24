package inf112.skeleton.app.map;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.object.Robot;

public class Laser extends Wall {

    TiledMapTileLayer.Cell cell;
    Integer wallID;
    Vector2 wallPos;
    int cellId;

    //laser shoots towards north
    public static int laserSOUTH = 37;
    //laser shoots towards east
    public static int laserWEST = 38;
    //int laserNORTH = ;

    //laser shoots towards west
    public static int laserEAST = 46;

    //laser shoots towards west
    public static int doubleLaserEAST = 95;

    TiledMapTileLayer laserLayer = RoboRally.getLaserLayer();


    public Laser(Vector2 wallPos, TiledMapTileLayer.Cell cell, int cellId) {
        super(wallPos, cellId);
    }

    public Boolean isLaserInFrontOfPlayer(Robot player){
        int xTest = ((int) player.getX());
        int yTest = ((int) player.getY());
        return (laserLayer.getCell(xTest, yTest).getTile().getId()) != 0;

        //int wallid = cell.getTile().getId();
        /*
        if ((x == laserXPos && y < laserYPos) && (cellId == laserSOUTH)) {
            System.out.println("Laser shooting towards NORTH");

            //TiledMapTileLayer.Cell wallTile = wallLayer.getCell(x,y);
            //if (wallTile != null)
            //cell.getTile().getId();
            for (float i = laserYPos; i > y; i--) {
                if (RoboRally.boardLayer.getCell(x,i)
            }

        }

        if ((x == laserXPos && y > laserYPos) && (cellId == WEST)) {
            System.out.println("Laser shooting towards EAST");
            return true;
        }

        if ((y == laserYPos && x < laserXPos) && (cellId == laserNORTH)) {
            System.out.println("Laser shooting towards SOUTH");
            return true;
        }

        if ((y == laserYPos && x > laserXPos) && (cellId == EAST)) {
            System.out.println("Wall facing EAST");
            return true;
        }
        */
    }

}
