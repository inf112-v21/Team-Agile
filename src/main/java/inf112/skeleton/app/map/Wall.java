package inf112.skeleton.app.map;

import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.map.object.Laser;
import inf112.skeleton.app.map.object.Robot;

public class Wall {

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


    public Wall() {
        wallPos = null;
        cellId = 0;
    }

    public Wall(Vector2 wallPos, int cellId) {
        this.wallPos = wallPos;
        this.cellId = cellId;
    }

    public Boolean isWallInSameTileInFrontOfPlayer(Robot player, int xDiff, int yDiff) {
        Vector2 playerCoordinate = new Vector2(player.getX(), player.getY());
        return checkForWall(player, xDiff, yDiff, playerCoordinate);
    }

    public boolean IsWallInNextTileInFrontOfPlayer(Robot player, int xDiff, int yDiff) {
        Vector2 playerCoordinate = new Vector2(player.getX()+xDiff, player.getY()+yDiff);
        return checkForWall(player, xDiff, yDiff, playerCoordinate);
    }

    private Boolean checkForWall(Robot player, int xDiff, int yDiff, Vector2 playerCoordinate) {
        boolean southCheck = ((cellId == SOUTH) || (cellId == Laser.laserSOUTH) || (cellId == outerWallSOUTH));
        boolean northCheck = (cellId == NORTH || (cellId == outerWallNORTH));
        boolean eastCheck = ((cellId == EAST) || (cellId == Laser.laserEAST) || (cellId == Laser.doubleLaserEAST) || (cellId == outerWallEAST));
        boolean westCheck = ((cellId == WEST) || (cellId == Laser.laserWEST) || (cellId == outerWallWEST));
        float rotation = player.getRotation();

        //System.out.println("xDiff = " + xDiff + " yDiff = " + yDiff + " Rotation = " + rotation);

        if(player.moveby == -1){
            //System.out.println("rot = " +  rotation + " southcheck " + southCheck + " moveby = " + player.moveby);
            if (playerCoordinate.equals(wallPos) && northCheck && rotation == 0 && yDiff == 1) { // Går baklengs nordover, yDiff = +1, moveby = -1, rot 0, skal sjekke at det ikke er en vegg i NORD tile posisjon
                System.out.println("VEGG ER I NEGATIV NORD");
                return true;
            } else if (playerCoordinate.equals(wallPos) && eastCheck && rotation == 270 && xDiff == 1) { // Går baklengs østover, xDiff = +1, moveby = -1, rot 270, skal sjekke at det ikke er en vegg i ØST tile posisjon
                System.out.println("VEGG ER I NEGATIV ØST");
                return true;
            } else if (playerCoordinate.equals(wallPos) && southCheck && rotation == 180 && yDiff == -1) { // Går baklengs sørover, yDiff = -1, moveby = -1, rot 180, skal sjekke at det ikke er en vegg i SØR tile posisjon
                System.out.println("VEGG ER I NEGATIV SØR");
                return true;
            } else if (playerCoordinate.equals(wallPos) && westCheck && rotation == 90 && xDiff == -1) { // Går baklengs vestover, xDiff = -1, moveby = -1, rot 270, skal sjekke at det ikke er en vegg i ØST tile posisjon
                System.out.println("VEGG ER I NEGATIV VEST");
                return true;
            } else return false;
        }



        else if (playerCoordinate.equals(wallPos) && southCheck && rotation == 0 && player.moveby == 1) { // Går foroverlent sørover, moveby = 1, rot 0, skal sjekke at det ikke er en vegg i SØR tile posisjon
            System.out.println("VEGG ER I POSITIV SØR");
            return true;
        } else if (playerCoordinate.equals(wallPos) && eastCheck && rotation == 90 && player.moveby == 1) {
            System.out.println("VEGG ER I POSITIV ØST");
            return true;
        } else if (playerCoordinate.equals(wallPos) && northCheck && rotation == 180 && player.moveby == 1) {
            System.out.println("VEGG ER I POSITIV NORD");
            return true;
        } else if (playerCoordinate.equals(wallPos) && westCheck && rotation == 270 && player.moveby == 1) {
            System.out.println("VEGG ER I POSITIV WEST");
            return true;
        } else return false;
    }

}
/**
 * float rotation = player.getRotation();
 if (playerCoordinate.equals(wallPos) && northCheck && rotation == 0) {
 System.out.println("VEGG ER I NESTE TILE NORD");
 return true; }
 else if (playerCoordinate.equals(wallPos) && westCheck && rotation == 90) {
 //System.out.println("Wall facing EAST");
 return true; }
 else if (playerCoordinate.equals(wallPos) && southCheck && rotation == 180) {
 //System.out.println("Wall facing NORTH");
 return true; }
 else if (playerCoordinate.equals(wallPos) && eastCheck && rotation == 270) {
 //System.out.println("Wall facing WEST");
 return true; }
 else return false;
 */