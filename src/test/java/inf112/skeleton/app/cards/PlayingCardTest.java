package inf112.skeleton.app.cards;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.map.object.InputHandler;
import inf112.skeleton.app.map.object.Robot;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayingCardTest {

    Robot player;
    PlayingCard card;


    RoboRally game = new RoboRally("MapNumber1.tmx", true);


    @Before
    public void setUp() throws Exception {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("CLOSE THIS WINDOW TO START THE TESTS");
        cfg.setWindowedMode(500, 100);



        new Lwjgl3Application(new Game() {
            @Override
            public void create() {
                game.show();
                Gdx.app.exit();
            }
        }, cfg);
    }

    //alle testene utføres fra utgangspunktet i pos (3,3) og start rotasjon => 0 dvs peker sørover

    @Test
    public void performUTurnsShouldReturn180degree() {
        player = new Robot(3,3, Color.BLACK, 1, game);

        player.setRotation(0);
        card = new PlayingCard(MoveType.UTURN, 10);

        player.rotate(card.getMove());

        assertEquals(180, (int) player.getRotation());

    }

    @Test
    public void performRotateRightShouldReturn270degree() {
        player =  new Robot(new TextureRegion(new Texture("pikachu.png")) , 3 , 3, "player 1");

        player.setRotation(0);
        card = new PlayingCard(MoveType.ROTATE_RIGHT, 10);

        player.rotate(card.getMove());

        assertEquals(270, (int) player.getRotation());
    }

    @Test
    public void performRotateLeftShouldReturn90degree() {
        player =  new Robot(new TextureRegion(new Texture("pikachu.png")) , 3 , 3, "player 1");

        player.setRotation(0);
        card = new PlayingCard(MoveType.ROTATE_LEFT, 10);

        player.rotate(card.getMove());

        assertEquals(90, (int) player.getRotation());
    }
    @Test
    public void performMoveOneShouldReturn2inYdirection() {
        player = new Robot(3,3, Color.BLACK, 1, game);

        player.setRotation(180);
        card = new PlayingCard(MoveType.MOVEONE, 10);

        player.move(card.getMove());

        assertEquals(4, (int) player.getY());
    }
    @Test
    public void performMoveTwoShouldReturn1inYdirection() {
        player = new Robot(3,3, Color.BLACK, 1, game);

        player.setRotation(180);
        card = new PlayingCard(MoveType.MOVETWO, 10);

        player.move(card.getMove());

        assertEquals(5, (int) player.getY());
    }

    @Test
    public void performMoveThreeShouldReturn0inYdirection() {
        player = new Robot(3,3, Color.BLACK, 1, game);

        player.setRotation(180);
        card = new PlayingCard(MoveType.MOVETHREE, 10);

        player.move(card.getMove());

        assertEquals(6, (int) player.getY());
    }


}

