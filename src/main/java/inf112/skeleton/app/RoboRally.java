package inf112.skeleton.app;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.esotericsoftware.kryonet.Client;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.cards.PlayingCard;
import inf112.skeleton.app.network.GameClient;
import inf112.skeleton.app.object.InputHandler;
import inf112.skeleton.app.object.Player;
import inf112.skeleton.app.object.Robot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RoboRally extends InputAdapter implements ApplicationListener {
    public SpriteBatch batch;
    private BitmapFont font;
    private TiledMap map;
    private TiledMapTileLayer boardLayer, playerLayer, holeLayer, flag1, flag2, flag3;
    private OrthogonalTiledMapRenderer render;
    private Integer flagsToTake = 4;
    private OrthographicCamera camera, font_cam;
    private ExtendViewport viewport;

    TextureRegion dead;
    TextureRegion win;
    Robot test;
    TextureRegion state1;
    TextureRegion[][] tr;
    Vector2 playerPosition;
    public Deck deck;
    public ArrayList<Player> players;
    public ArrayList<Robot> robots;
    String text;
    Robot test2;
    public GameClient client;
    public InputHandler handler;
    public ArrayList<Color> colors;

    public Robot clientPlayer;







    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/17green.fnt"));
        colors = new ArrayList<>(Arrays.asList(Color.LIGHT_GRAY, Color.ORANGE, Color.LIME, Color.YELLOW));



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
        flag1 = (TiledMapTileLayer) map.getLayers().get("Flag1");
        flag2 = (TiledMapTileLayer) map.getLayers().get("Flag2");
        flag3 = (TiledMapTileLayer) map.getLayers().get("Flag3");



        render = new OrthogonalTiledMapRenderer(map , 1/300f);

        Texture texture = new Texture("player.png");

        deck = new Deck();
        players = new ArrayList<>();
        robots = new ArrayList<>();


        // splitter opp player.png bildet og definerer størrelsen
        /*
        tr = TextureRegion.split(texture, 300, 300);

        state1 = tr[0][0];
        dead = tr[0][1];
        win = tr[0][2];



        playerPosition = new Vector2(0, 0);

        test = new Robot(state1, 2,2);


         */



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

    public ArrayList<Robot> playerToRobot(ArrayList<Player> spillerliste) {
        robots.clear();
        for(int i = 0; i < spillerliste.size() ; i++) {
            Robot robot = new Robot(spillerliste.get(i).x, spillerliste.get(i).y, colors.get(i), spillerliste.get(i).id);
            robots.add(robot);
        }
        return robots;
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
        Gdx.input.setInputProcessor(handler);

        viewport.apply();
        render.setView((OrthographicCamera) viewport.getCamera());
        render.render();

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        drawPlayers(robots, batch);
        if(clientPlayer != null && !clientPlayer.cards.isEmpty()) {
            clientPlayer.renderCards(batch);
            batch.setProjectionMatrix(font_cam.combined);
            clientPlayer.renderPriority(batch);
        }
        batch.end();

    if(clientPlayer != null) {
        checkrobotStates(robots);
        checkFlags(robots);
        allFlagsTaken(robots);
        }

    }
    public void checkrobotStates(ArrayList<Robot> robotliste) {
        for(Robot r : robotliste) {
            if (holeLayer.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.changeState("dead");
            } else {
                r.changeState("normal");
            }
        }
    }

    public void checkFlags(ArrayList<Robot> robotliste) {
        for(Robot r : robotliste) {
            if (flag1.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.visitFlag(1);
            } else if (flag2.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.visitFlag(2);
            } else if (flag3.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.visitFlag(3);
            }
        }
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

    public void allFlagsTaken(ArrayList<Robot> robotliste) {
        for (Robot r : robotliste) {
            if (r.getFlag() == flagsToTake) {
                Gdx.app.exit();
            }
        }
    }
}
