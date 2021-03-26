package inf112.skeleton.app.map;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.object.Robot;

public class Laser extends Wall {

    //TiledMapTileLayer.Cell cell;
    //Integer wallID;
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


    public Laser(Vector2 wallPos, int cellId) {
        this.wallPos = wallPos;
        this.cellId = cellId;
    }

    public Vector2 getLaserPos() {
        return this.wallPos;
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

    /*
    public String laserTypeInNextTile(Robot player, int xDiff, int yDiff) {
        //float rotation = player.getRotation();
        Vector2 playerCoordinate = new Vector2(player.getX()+xDiff, player.getY()+yDiff);

        boolean southCheck = cellId == Laser.laserSOUTH);
        //boolean northCheck = (cellId == laserNORTH);
        boolean eastCheck = (cellId == Laser.laserEAST);
        boolean eastDoubleCheck = (cellId == Laser.doubleLaserEAST);
        boolean westCheck = (cellId == Laser.laserWEST);


        /*
        if (playerCoordinate.equals(wallPos) && northCheck && rotation == 0) {
            System.out.println("Wall facing SOUTH");
            return true; }


        if (playerCoordinate.equals(wallPos) && westCheck) {
            System.out.println("Laser facing EAST");
            return "East"; }
        else if (playerCoordinate.equals(wallPos) && southCheck) {
            System.out.println("Laser facing NORTH");
            return "North"; }
        else if (playerCoordinate.equals(wallPos) && eastCheck) {
            System.out.println("Laser facing WEST");
            return "West"; }
        else if (playerCoordinate.equals(wallPos) && eastDoubleCheck) {
            System.out.println("Double laser facing WEST");
            return "DoubleWest"; }
        else return "Nothing";
    }
    */

    public int getCellId() {
        return this.cellId;
    }

}
