package inf112.skeleton.app.map.object;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.map.Wall;

public class Laser extends Wall {

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

    public Boolean isLaserInFrontOfPlayer(Robot player) {
        int xTest = ((int) player.getX());
        int yTest = ((int) player.getY());
        return (laserLayer.getCell(xTest, yTest).getTile().getId()) != 0;
    }

    public int getCellId() {
        return this.cellId;
    }

}