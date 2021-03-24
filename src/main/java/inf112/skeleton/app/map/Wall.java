package inf112.skeleton.app.map;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.object.Robot;

public class Wall {

    TiledMapTileLayer.Cell cell;
    Vector2 wallPos;
    int cellId;

    // wall values from .tmx-file:
    static int SOUTH = 29;
    static int WEST = 30;
    static int NORTH = 31;
    static int EAST = 23;

    // create a random ID to be used for outer walls:
    public static int outerWallSOUTH = 290;
    public static int outerWallWEST= 300;
    public static int outerWallNORTH = 310;
    public static int outerWallEAST = 230;



    public Vector2 getWallPos() {
        return wallPos;
    }

    public int getCellId() {
        return cellId;
    }

    public Wall(Vector2 wallPos, int cellId){
        this.wallPos = wallPos;
        this.cellId = cellId;
    }

    public Boolean isWallInFrontOfPlayer(Robot player, float x, float y){



        float rotation = player.getRotation();
        Vector2 playerCoordinate = new Vector2(x, y);
        System.out.println("CELL ID: " + cellId);
        if (playerCoordinate.equals(wallPos) && ((cellId == SOUTH) || (cellId == Laser.laserSOUTH) || (cellId == outerWallSOUTH)) && rotation == 0) {
            System.out.println("Wall facing SOUTH");
            return true; }

        else if (playerCoordinate.equals(wallPos) && ((cellId == EAST) || (cellId == Laser.laserEAST) || (cellId == Laser.doubleLaserEAST) || (cellId == outerWallEAST)) && rotation == 90) {
            System.out.println("Wall facing EAST");
            return true; }

        else if(playerCoordinate.equals(wallPos) && (cellId == NORTH || (cellId == outerWallNORTH)) && rotation == 180) {
            System.out.println("Wall facing NORTH");
            return true; }

        else if (playerCoordinate.equals(wallPos) && ((cellId == WEST) || (cellId == Laser.laserWEST)|| (cellId == outerWallWEST)) && rotation == 270) {
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
 *
 *
 * int boardHeightStartPos = 2;
 * int boardHeight = boardHeightStartPos + 12;
 * int boardWidth = 17;
 */
