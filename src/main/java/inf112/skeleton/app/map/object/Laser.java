package inf112.skeleton.app.map.object;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.map.Wall;

/**
 * Laser extender Wall og oppretter et objekt som
 * representerer en Laser, det vil si en vegg som
 * har egenskapen å kunne avfyre en laserstråle.
 * Lasere legges til ArrayListen allwalls, og i tillegg
 * legges de til en egen ArrayList som kun inneholder
 * lasere, slik at de også kan behandles seperat som lasere.
 *
 * @author Team Agile
 *
 */

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



    public int getCellId() {
        return this.cellId;
    }

}
