package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.map.Spawn;
import inf112.skeleton.app.network.GameClient;
import inf112.skeleton.app.map.Laser;
import inf112.skeleton.app.map.Wall;
import inf112.skeleton.app.network.GameServer;
import inf112.skeleton.app.object.InputHandler;
import inf112.skeleton.app.object.Player;
import inf112.skeleton.app.object.Robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class RoboRally extends InputAdapter implements ApplicationListener {

    public SpriteBatch batch;
    private BitmapFont font;
    public TiledMap map;
    public static TiledMapTileLayer boardLayer, playerLayer, holeLayer, wallLayer, laserLayer, flag1, flag2, flag3, startPositions;
    public OrthogonalTiledMapRenderer render;
    public Integer flagsToTake = 4;
    private OrthographicCamera camera, font_cam;
    private FitViewport viewport;
    public String mapChosen;

    public Deck deck;
    public ArrayList<Player> players;
    public ArrayList<Robot> robots;

    public GameClient client;
    public InputHandler handler;
    public ArrayList<Color> colors;

    public Robot clientPlayer;

    int boardHeightStartPos = 2;
    int boardHeight = boardHeightStartPos + 11;
    int boardWidth = 16;

    public ArrayList<Wall> allWalls = new ArrayList<>();
    public ArrayList<Laser> allLasers = new ArrayList<>();
    public HashMap<Integer, Spawn> spawns = new HashMap<>();
    public String gameState = "pickCards";
    private boolean host;

    private CreateGame newGame;
    public CheckEvents checkevent;


    public RoboRally(String mapChosen, boolean host){
        this.mapChosen = mapChosen;
        this.host = host;
        newGame = new CreateGame(this);
        checkevent = new CheckEvents(this);
    }

    @Override
    public void create() {

        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/15green.fnt"));
        colors = new ArrayList<>(Arrays.asList(Color.WHITE,Color.GREEN, Color.LIGHT_GRAY,  Color.FIREBRICK , Color.ORANGE, Color.LIME, Color.YELLOW,  Color.FOREST));

        camera = new OrthographicCamera();
        viewport = new FitViewport(29,14);
        font_cam = new OrthographicCamera();
        font_cam.setToOrtho(false, 1339,750);
        newGame.initalize();

        render = new OrthogonalTiledMapRenderer(map , 1/300f);

        if(host) {
            try {
                GameServer server = new GameServer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
            Robot robot = new Robot((int)spawns.get(i).getSpawnpos().x, (int)spawns.get(i).getSpawnpos().y, colors.get(i), spillerliste.get(i).id, this);
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

        if (clientPlayer != null && !clientPlayer.cards.isEmpty()) {
            clientPlayer.renderCards(batch);
            batch.setProjectionMatrix(font_cam.combined);
            clientPlayer.renderPriority(batch);

        }
        if (clientPlayer != null) {
            batch.setProjectionMatrix(font_cam.combined);
            clientPlayer.initializeHud(batch);
        }

        batch.end();

        if (clientPlayer != null && gameState.equals("check")) {
            checkevent.checkrobotStates(robots);
            checkevent.checkFlags(robots);
            checkevent.allFlagsTaken(robots);
            checkevent.checkLaserBeams(allLasers);
            gameState = "pickCards";
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

    public static TiledMapTileLayer getLaserLayer() {
        return laserLayer;
    }

}
