package inf112.skeleton.app.map;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

/**
 * Et booster objekt representerer et rullebånd
 * på mapet, som kan ha forskjellige egenskaper i
 * forhold til hvor fort det går, om det roterer
 * og i hvilken retning det går i.
 *
 * @author Team Agile
 *
 */

public class Booster {

    TiledMapTileLayer.Cell cell;

    Vector2 position; //(x,y)
    DirectionEnum direction; //NORTH, EAST, SOUTH, WEST
    int speed; //1, 2
    int turn; //-90, 0, +90




    //Single straight booster
    public static int UP = 49;    //+y (NORTH)
    public static int DOWN = 50;  //-y (SOUTH)
    public static int LEFT = 51;  //-x (WEST)
    public static int RIGHT = 52; //+x (EAST)

    //Single turn booster
    //mot klokken
    public static int LEFTDOWN = 33;  //-y (SOUTH), +90
    //med klokken
    public static int RIGHTDOWN = 36; //-y (SOUTH), -90

    //Double straight booster
    public static int UPP = 13;    //+y (NORTH), 2step
    public static int DOWNN = 21;  //-y (SOUTH), 2step
    public static int LEFTT = 22;  //-x (WEST), 2step

    //Double turn booster
    //med klokken
    public static int DOWNLEFT = 28; //-x (WEST), 2step, -90
    public static int LEFTUPUP = 77; //+y (NORTH), 2step, kommer du fra høyre side (-90), kommer du nedifra (0)

    /*
    UP id 49


     */
    public Booster(Vector2 position, DirectionEnum direction, int speed, int turn) {
        this.position = position;
        this.direction = direction;
        this.speed = speed;
        this.turn = turn;
    }

    public Vector2 getPosition() {
        return position;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public int getTurn() {
        return turn;
    }

    public int getSpeed(){
        return this.speed;
    }



    public static void isThisTurn(){

    }
}

