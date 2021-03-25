package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("RoboRally Game");
        //1553,750
        cfg.setWindowedMode(1398,675);
        cfg.setResizable(false);


        new Lwjgl3Application(new RoboRally("MapNumber1.tmx"), cfg);
    }
}
