package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.esotericsoftware.kryonet.Client;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.network.GameClient;
import inf112.skeleton.app.object.InputHandler;
import inf112.skeleton.app.object.Robot;

import java.io.IOException;
import java.util.ArrayList;

public class RoboRally extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    private TiledMap map;
    private TiledMapTileLayer boardLayer, playerLayer, holeLayer, flagLayer;
    private OrthogonalTiledMapRenderer render;
    private Integer flagsToTake = 2;
    private OrthographicCamera camera, font_cam;
    private ExtendViewport viewport;

    TextureRegion dead;
    TextureRegion win;
    Robot test;
    TextureRegion state1;
    TextureRegion[][] tr;
    Vector2 playerPosition;
    Deck deck;
    public ArrayList<Robot> players;
    String text;
    Robot test2;
    GameClient client;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/17green.fnt"));
        text = "220";

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(23,14);
        font_cam = new OrthographicCamera();
        font_cam.setToOrtho(false, 1339,750);

        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("maps/tutorial.tmx");

        //Layers initialize
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");


        render = new OrthogonalTiledMapRenderer(map , 1/300f);

        Texture texture = new Texture("player.png");

        deck = new Deck();

        // splitter opp player.png bildet og definerer størrelsen
        tr = TextureRegion.split(texture, 300, 300);

        state1 = tr[0][0];
        dead = tr[0][1];
        win = tr[0][2];

        playerPosition = new Vector2(0, 0);

        test = new Robot(state1,2,2);
        test2 = new Robot(state1,4,4);

        InputHandler myhandler = new InputHandler(test);

        players = new ArrayList<>();

       // players.add(test);
       // players.add(test2);

        deck.dealOutCards(players);

        test.playerCardstoHand(test.getCards());

        Gdx.input.setInputProcessor(myhandler);

        try {
            client = new GameClient(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public void drawPlayers(ArrayList<Robot> spillerliste, SpriteBatch batch) {

        for(Robot r : spillerliste) {
            r.draw(batch);
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        render.setView((OrthographicCamera) viewport.getCamera());
        render.render();

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        drawPlayers(players, batch);
        batch.end();

        /*
        test.draw(batch);
        //test.renderCards(batch);

        batch.setProjectionMatrix(font_cam.combined);
        test.renderPriority(batch);

        batch.end();
*/

        if (holeLayer.getCell((int) test.getX(), (int) test.getY()) != null) {
            test.setRegion(dead);
        } else if (flagLayer.getCell((int) test.getX(), (int) test.getY()) != null) {
            test.setRegion(win);
            test.visitFlag(1);
        } else {
            test.setRegion(state1);
        }

        allFlagsTaken(test);


    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        viewport.getCamera().update();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    public void allFlagsTaken(Robot player) {
        if (player.getFlag() == flagsToTake) {
            Gdx.app.exit();
        }
    }

}
