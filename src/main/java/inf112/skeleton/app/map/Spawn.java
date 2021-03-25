package inf112.skeleton.app.map;

import com.badlogic.gdx.math.Vector2;

public class Spawn {



    Vector2 spawnpos;
    public static int spawn1 = 121;
    public static int spawn2 = 122;
    public static int spawn3 = 123;
    public static int spawn4 = 124;
    public static int spawn5 = 129;
    public static int spawn6 = 130;
    public static int spawn7 = 131;
    public static int spawn8 = 132;


    public Spawn(Vector2 spawnpos) {
        this.spawnpos = spawnpos;
    }

    public Vector2 getSpawnpos() {
        return spawnpos;
    }


}
