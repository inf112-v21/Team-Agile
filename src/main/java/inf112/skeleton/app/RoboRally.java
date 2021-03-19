package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.object.InputHandler;
import inf112.skeleton.app.object.Robot;

import java.util.ArrayList;

public class RoboRally extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;

    private TiledMapTileLayer holeLayer;
    private TiledMapTileLayer flagLayer;
    private OrthogonalTiledMapRenderer render;
    private OrthographicCamera font_cam;
    private ExtendViewport viewport;

    Integer flagsToTake = 2;
    TextureRegion dead;

    TextureRegion win;

    Robot robot;
    TextureRegion state1;
    TextureRegion[][] tr;
    Vector2 playerPosition;
    Deck deck;
    ArrayList<Robot> players;

    @Override
    public void create() {
        batch = new SpriteBatch();

        viewport = new ExtendViewport(23,14);
        font_cam = new OrthographicCamera();
        font_cam.setToOrtho(false, 1339,750);

        TmxMapLoader loader = new TmxMapLoader();
        TiledMap map = loader.load("maps/tutorial.tmx");

        //Layers initialize
        TiledMapTileLayer boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        TiledMapTileLayer playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");

        render = new OrthogonalTiledMapRenderer(map, 1/300f);

        Texture texture = new Texture("player.png");

        tr = TextureRegion.split(texture, 300, 300);
        state1 = tr[0][0];
        dead = tr[0][1];
        win = tr[0][2];

        playerPosition = new Vector2(0, 0);
        robot = new Robot(state1,2,2, "Player 1");

        InputHandler myHandler = new InputHandler(robot);

        deck = new Deck();
        players = new ArrayList<>();
        players.add(robot);

        deck.dealOutCards(players);
        robot.playerCardstoHand(robot.getCards());

        Gdx.input.setInputProcessor(myHandler);
    }

    @Override
    public void dispose() {
        batch.dispose();
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
        robot.draw(batch);
        robot.renderCards(batch);

        batch.setProjectionMatrix(font_cam.combined);
        robot.renderPriority(batch);
        robot.initializeHud(batch);

        batch.end();


        if (holeLayer.getCell((int) robot.getX(), (int) robot.getY()) != null) {
            robot.setRegion(dead);
            robot.decreaseRobotHealthpoint(-1);
            robot.renderHud("You lost 1 HP", batch, 0);
        } else if (flagLayer.getCell((int) robot.getX(), (int) robot.getY()) != null) {
            robot.setRegion(win);
            robot.visitFlag(1);
            robot.renderHud("Flag: " + 1 + " was taken\n" + (flagsToTake-1) + " numbers of flags left", batch, 0);
        } else {
            robot.setRegion(state1);
        }
        allFlagsTaken(robot);
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
        if (player.getFlag().equals(flagsToTake)) {
            player.renderHud("Player " + player.getName() + " won the game!\nRestart the game to start again", batch, 2);
        }
    }
}
