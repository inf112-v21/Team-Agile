package inf112.skeleton.app.map;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.object.Robot;

public class Wall {

    TiledMapTileLayer.Cell cell;
    Vector2 wallPos;
    int cellId;

    // wall values from .tmx-file:
    public static int SOUTH = 29;
    public static int WEST = 30;
    public static int NORTH = 31;
    public static int EAST = 23;

    // create a random ID to be used for outer walls:
    public static int outerWallSOUTH = 290;
    public static int outerWallWEST = 300;
    public static int outerWallNORTH = 310;
    public static int outerWallEAST = 230;

    public Wall(Vector2 wallPos, int cellId) {
        this.wallPos = wallPos;
        this.cellId = cellId;
    }

    public Boolean isWallInFrontOfPlayer(Robot player) {
        Vector2 playerCoordinate = new Vector2(player.getX(), player.getY());
        float rotation = player.getRotation();
        boolean southCheck = ((cellId == SOUTH) || (cellId == Laser.laserSOUTH) || (cellId == outerWallSOUTH));
        boolean northCheck = (cellId == NORTH || (cellId == outerWallNORTH));
        boolean eastCheck = ((cellId == EAST) || (cellId == Laser.laserEAST) || (cellId == Laser.doubleLaserEAST) || (cellId == outerWallEAST));
        boolean westCheck = ((cellId == WEST) || (cellId == Laser.laserWEST) || (cellId == outerWallWEST));

        if (playerCoordinate.equals(wallPos) && southCheck && rotation == 0) {
            System.out.println("Wall facing SOUTH");
            return true;
        } else if (playerCoordinate.equals(wallPos) && eastCheck && rotation == 90) {
            System.out.println("Wall facing EAST");
            return true;
        } else if (playerCoordinate.equals(wallPos) && northCheck && rotation == 180) {
            System.out.println("Wall facing NORTH");
            return true;
        } else if (playerCoordinate.equals(wallPos) && westCheck && rotation == 270) {
            System.out.println("Wall facing WEST");
            return true;
        } else return false;
    }

    public boolean isWallInNextTile(Robot player, int xDiff, int yDiff) {
        float rotation = player.getRotation();
        Vector2 playerCoordinate = new Vector2(player.getX()+xDiff, player.getY()+yDiff);

        boolean southCheck = ((cellId == SOUTH) || (cellId == Laser.laserSOUTH) || (cellId == outerWallSOUTH));
        boolean northCheck = (cellId == NORTH || (cellId == outerWallNORTH));
        boolean eastCheck = ((cellId == EAST) || (cellId == Laser.laserEAST) || (cellId == Laser.doubleLaserEAST) || (cellId == outerWallEAST));
        boolean westCheck = ((cellId == WEST) || (cellId == Laser.laserWEST) || (cellId == outerWallWEST));


        if (playerCoordinate.equals(wallPos) && northCheck && rotation == 0) {
            System.out.println("Wall facing SOUTH");
            return true; }
        else if (playerCoordinate.equals(wallPos) && westCheck && rotation == 90) {
            System.out.println("Wall facing EAST");
            return true; }
        else if (playerCoordinate.equals(wallPos) && southCheck && rotation == 180) {
            System.out.println("Wall facing NORTH");
            return true; }
        else if (playerCoordinate.equals(wallPos) && eastCheck && rotation == 270) {
            System.out.println("Wall facing WEST");
            return true; }
        else return false;
    }
}