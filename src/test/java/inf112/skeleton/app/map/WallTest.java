package inf112.skeleton.app.map;


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

import static org.junit.Assert.*;

public class WallTest {


    Wall wall;
    Vector2 wallPos;
    int cellID;
    Robot robot, robot2, robot3, robot4, robot5;
    RoboRally game = new RoboRally("tutorial.tmx" , true);

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

    // setter opp vegg, og gir mulighet for å bestemme hvilken type vegg som skal brukes
    public void setUpNewWall(int id){
        wall = new Wall(new Vector2(3,3), id);
        game.allWalls.add(wall);
    }

    @Test
    public void testIfWallIsInFrontOfPlayerSouth(){
        setUpNewWall(29); // setter opp type vegg, her står veggen sør for spiller men på samme tile som spiller
        robot.setRotation(0); // når spiller skal bevege seg sørover er rotasjonen til spiller = 0
        robot.move(1); // tar et steg for å sjekke om man stoppes av veggen
        assertEquals(3, (int) robot.getX()); // skal få samme posisjon siden hvis man beveger seg i sør retning vil x posisjon forbli den samme
        assertEquals(3, (int) robot.getY()); // vil ha samme posisjon tilbake for å bevise at det finnes vegg i veien for spiller
    }

    @Test
    public void testIfWallIsInFrontOfPlayerNorth(){
        robot.setRotation(180); // når man skal nord må man rotere 180 grader
        setUpNewWall(31); // vegg som står i nord posisjon har celle id 31
        robot.move(1); // tar et steg
        assertEquals(3, (int) robot.getX()); // her skal posisjonen uansett være den samme
        assertEquals(3, (int) robot.getY()); // her skulle egentlig posisjonen vert +1, men siden vegg er i veien forventes samme posisjon
    }
    @Test
    public void testIfWallIsInFrontOfPlayerEast(){
        robot.setRotation(90); // rotasjon for å kunne gå øst
        setUpNewWall(23); // vegg i øst retning for spiller
        robot.move(1); // går et steg
        assertEquals(3, (int) robot.getX()); // sjekker at selv om man går et steg til høyre vil man ha samme x-posisjon pga vegg.
        assertEquals(3,(int) robot.getY()); // vil få samme posisjon uansett om vegg eller ikke

    }
    @Test
    public void testIfWallIsInFrontOfPlayerWest(){
        robot.setRotation(270); // rotasjon mot vest
        setUpNewWall(30); // setter opp vegg i vest retning for spiller
        robot.move(1); // beveger oss vestover
        assertEquals(3, (int) robot.getX()); // skal sjekke at spiller ikke beveger seg vestover pga vegg
        assertEquals(3, (int) robot.getY()); // vil få samme posisjon uansett.
    }

    public void setUpNewWallInTileInFrontOfPlayer(int cellId){ // Til å sette opp vegger i tile foran spiller
        wall = new Wall(new Vector2(4,4),cellId);
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
