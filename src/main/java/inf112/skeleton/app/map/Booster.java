package inf112.skeleton.app.map;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Booster {

    TiledMapTileLayer.Cell cell;

    Vector2 position; //(x,y)
    int direction; //0, 90, 180, 270
    int speed; //1, 2
    boolean turn; //true , false


    //Single straight booster
    public static int UP = 49;
    public static int DOWN = 50;
    public static int LEFT = 51;
    public static int RIGHT = 52;

    //Single turn booster
    //mot klokken
    public static int LEFTDOWN = 33;
    //med klokken
    public static int RIGHTDOWN = 36;

    //Double straight booster
    public static int UPP = 13;
    public static int DOWNN = 21;
    public static int LEFTT = 22;

    //Double turn booster
    //med klokken
    public static int DOWNLEFT = 28;
    public static int LEFTUPUP = 77;

    public Booster(Vector2 position, int direction, int speed, boolean turn) {
        this.position = position;
        this.direction = direction;
        this.speed = speed;
        this.turn = turn;
    }

    public



}
