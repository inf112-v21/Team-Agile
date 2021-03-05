package inf112.skeleton.app.Cards;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.skeleton.app.Object.Robot;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class DeckTest {

    Deck deck;
    Robot player1;
    Robot player2;
    Robot player3;
    ArrayList<Robot> players;


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

        createDeck();

    }

    void createDeck() {
        deck = new Deck();
    }

    @Test
    public void testThatDeckNumberEquals84() {
        assertEquals(84, deck.getSize());
    }

    @Test
    public void testThatDeckActuallyGetsShuffled() {
        // Testing with 5 random playingCards
        PlayingCard testBefore1 = deck.getIndex(3);
        PlayingCard testBefore2 = deck.getIndex(22);
        PlayingCard testBefore3 = deck.getIndex(34);
        PlayingCard testBefore4 = deck.getIndex(56);
        PlayingCard testBefore5 = deck.getIndex(78);

        deck.shuffle();

        PlayingCard testAfter1 = deck.getIndex(3);
        PlayingCard testAfter2 = deck.getIndex(22);
        PlayingCard testAfter3 = deck.getIndex(34);
        PlayingCard testAfter4 = deck.getIndex(56);
        PlayingCard testAfter5 = deck.getIndex(78);

        assertNotEquals(testBefore1, testAfter1);
        assertNotEquals(testBefore2, testAfter2);
        assertNotEquals(testBefore3, testAfter3);
        assertNotEquals(testBefore4, testAfter4);
        assertNotEquals(testBefore5, testAfter5);
    }

    @Test
    public void testThatDeckIsDealingOutCards() {
        createPlayersAndDealOutDeck();

        assertNotNull(player1.getCards());
        assertNotNull(player2.getCards());
        assertNotNull(player3.getCards());

    }

    @Test
    public void testThatNumberOfCardsInHandIsCorrespondingWithRobotHP() {
        createPlayersAndDealOutDeck();

        assertEquals(5, player1.getCards().size());
        assertEquals(7, player2.getCards().size());
        assertEquals(3, player3.getCards().size());
    }

    public void createPlayersAndDealOutDeck(){
        player1 = new Robot(new TextureRegion(new Texture("pikachu.png")) , 3 , 3);
        player2 = new Robot(new TextureRegion(new Texture("pikachu.png")) , 8 , 5);
        player3 = new Robot(new TextureRegion(new Texture("pikachu.png")) , 5 , 8);

        player1.setHealthpoint(5);
        player2.setHealthpoint(7);
        player3.setHealthpoint(3);

        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        deck.dealOutCards(players);
    }


}