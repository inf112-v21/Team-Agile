package inf112.skeleton.app.object;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.map.Wall;
import inf112.skeleton.app.object.Robot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WallTest {


    Wall wall;
    Vector2 wallPos;
    int cellID;
    Robot robot, robot2, robot3, robot4, robot5;
    RoboRally game = new RoboRally("tutorial.tmx");

    /**
     * Setter opp robot og adder posisjon av vegg til liste, og tester at dersom man beveger ved hjelp av funksjonen
     * move (som kaller opp metoder i wall) seg et steg så skal en få samme posisjon tilbake
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("CLOSE THIS WINDOW TO START THE TESTS");
        cfg.setWindowedMode(500, 100);
        new Lwjgl3Application(new Game() {
            @Override
            public void create() {
                Gdx.app.exit();
            }
        }, cfg);
        robot = new Robot(3,3, Color.BLACK,1,game);
    }

    /**
     *     // wall values from .tmx-file:
     *     public static int SOUTH = 29;
     *     public static int WEST = 30;
     *     public static int NORTH = 31;
     *     public static int EAST = 23;
     *
     *     // create a random ID to be used for outer walls:
     *     public static int outerWallSOUTH = 290;
     *     public static int outerWallWEST = 300;
     *     public static int outerWallNORTH = 310;
     *     public static int outerWallEAST = 230;
     *
     *     PlayerRotation 0 = wallPosition south
     *     PlayerRotation 90 = wallPosition East
     *     PlayerRotation 180 = wallPosition North
     *     playerRotation 270 = wallPosition West
     * @param id
     */

    public void setUpNewWall(int id){
        wall = new Wall(new Vector2(3,3), id);
        game.allWalls.add(wall);
    }

    @Test
    public void testIfWallIsInFrontOfPlayerSouth(){
        setUpNewWall(29); //setter opp type vegg, her står veggen sør for spiller men på samme tile som spiller
        robot.setRotation(0); // når spiller skal bevege seg sørover er rotasjonen til spiller = 0
        robot.move(1); // tar et steg for å sjekke om man stoppes av veggen
        assertEquals(3, (int) robot.getX()); // når vi skal bevege oss sørover, vil x posisjon bevege seg, men siden det skal være vegg der forventer vi samme posisjon
        assertEquals(3, (int) robot.getY());//forventer samme posisjon for y uansett om spiller beveger seg eller ikke
    }

    @Test
    public void testIfWallIsInFrontOfPlayerNorth(){
        robot.setRotation(180); // når man skal nord må man rotere 180 grader
        setUpNewWall(31); //vegg som står i nord posisjon har celle id 31
        robot.move(1);//tar et steg
        assertEquals(3, (int) robot.getX());//
        assertEquals(3, (int) robot.getY());
    }
    @Test
    public void testIfWallIsInFrontOfPlayerEast(){
        robot.setRotation(90);
        setUpNewWall(23);
        robot.move(1);
        assertEquals(3, (int) robot.getX());
        assertEquals(3,(int) robot.getY());

    }
    @Test
    public void testIfWallIsInFrontOfPlayerWest(){
        robot.setRotation(270);
        setUpNewWall(30);
        robot.move(1);
        assertEquals(3, (int) robot.getX());
        assertEquals(3, (int) robot.getY());
    }

    public void setUpNewWallInTileInFrontOfPlayer(int cellId){
        wall = new Wall(new Vector2(4,4),cellId); // NORTH
        game.allWalls.add(wall);
    }

    @Test
    public void testIfWallIsInTileInFrontOfPlayerSouth(){
        setUpNewWallInTileInFrontOfPlayer(31); // setter opp en vegg i posisjon NORD i selve tile x = 4, y = 4
        robot2 = new Robot(4,5, Color.BLACK,1,game); // setter robot opp i tile ovenfor vegg-tile.
        robot2.setRotation(0); // setter rotasjon til at roboten skal gå sørover
        robot2.move(1);

        // sjekker at robot ikke har beveg seg
        assertEquals(4, (int) robot2.getX());
        assertEquals(5, (int) robot2.getY());
    }

    @Test
    public void testIfWallIsInTileInFrontOfPlayerNorth(){
        setUpNewWallInTileInFrontOfPlayer(29); // setter opp en vegg i posisjon SØR i selve tile x = 4, y = 4
        robot3 = new Robot(4,3, Color.BLACK,1,game); // setter robot opp i tile nedenfor vegg-tile.
        robot3.setRotation(180); // setter rotasjon til at roboten skal gå nordover
        robot3.move(1);

        // sjekker at robot ikke har beveg seg
        assertEquals(4, (int) robot3.getX());
        assertEquals(3, (int) robot3.getY());
    }

    @Test
    public void testIfWallIsInTileInFrontOfPlayerEast(){
        setUpNewWallInTileInFrontOfPlayer(30); // setter opp en vegg i posisjon VEST i selve tile x = 4, y = 4
        robot4 = new Robot(3,4, Color.BLACK,1,game); // setter robot opp i tile bortenfor vegg-tile.
        robot4.setRotation(90); // setter rotasjon til at roboten skal gå østover
        robot4.move(1);

        // sjekker at robot ikke har beveg seg
        assertEquals(3, (int) robot4.getX());
        assertEquals(4, (int) robot4.getY());
    }

    @Test
    public void testIfWallIsInTileInFrontOfPlayerWest(){
        setUpNewWallInTileInFrontOfPlayer(23); // setter opp en vegg i posisjon ØST i selve tile x = 4, y = 4
        robot5 = new Robot(5,4, Color.BLACK,1,game); // setter robot opp i tile bortenfor vegg-tile.
        robot5.setRotation(270); // setter rotasjon til at roboten skal gå vestover
        robot5.move(1);

        // sjekker at robot ikke har beveg seg
        assertEquals(5, (int) robot5.getX());
        assertEquals(4, (int) robot5.getY());
    }


}
