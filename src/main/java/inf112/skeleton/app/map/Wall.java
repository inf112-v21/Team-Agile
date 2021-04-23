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

    public Boolean isWallInSameTileInFrontOfPlayer(Robot player) {
        Vector2 playerCoordinate = new Vector2(player.getX(), player.getY());
        float rotation = player.getRotation();

        if (player.moveby == -1) return checkWall2(playerCoordinate, rotation);
        else return checkWall(playerCoordinate, rotation);
    }

    public boolean IsWallInNextTileInFrontOfPlayer(Robot player, int xDiff, int yDiff) {
        Vector2 playerCoordinate = new Vector2(player.getX()+xDiff, player.getY()+yDiff);
        float rotation = player.getRotation();

        if(player.moveby == -1) return checkWall(playerCoordinate, rotation);
        else return checkWall2(playerCoordinate, rotation);
    }

    private Boolean checkWall(Vector2 playerCoordinate, float rotation) {
        if (playerCoordinate.equals(wallPos) && southCheck() && rotation == 0) return true;
        else if (playerCoordinate.equals(wallPos) && eastCheck() && rotation == 90) return true;
        else if (playerCoordinate.equals(wallPos) && northCheck() && rotation == 180) return true;
        else return playerCoordinate.equals(wallPos) && westCheck() && rotation == 270;
    }

    private boolean checkWall2(Vector2 playerCoordinate, float rotation) {
        if (playerCoordinate.equals(wallPos) && northCheck() && rotation == 0) return true;
        else if (playerCoordinate.equals(wallPos) && westCheck() && rotation == 90) return true;
        else if (playerCoordinate.equals(wallPos) && southCheck() && rotation == 180) return true;
        else return playerCoordinate.equals(wallPos) && eastCheck() && rotation == 270;
    }

    boolean northCheck(){
        return (cellId == NORTH || (cellId == outerWallNORTH)); }

    boolean southCheck(){
        return ((cellId == SOUTH) || (cellId == Laser.laserSOUTH) || (cellId == outerWallSOUTH)); }

    boolean eastCheck(){
        return ((cellId == EAST) || (cellId == Laser.laserEAST) || (cellId == Laser.doubleLaserEAST) || (cellId == outerWallEAST)); }

    boolean westCheck(){
        return ((cellId == WEST) || (cellId == Laser.laserWEST) || (cellId == outerWallWEST)); }
}