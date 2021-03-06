package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import inf112.skeleton.app.Screens.GameScreen;
import inf112.skeleton.app.Screens.StartGame;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.map.*;
import inf112.skeleton.app.network.GameClient;
import inf112.skeleton.app.network.GameServer;
import inf112.skeleton.app.map.object.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * RoboRally er klassen som alle andre klasser ender opp med å sende
 * info om spillet til. Den holder styr på alle spillere, kortene,
 * veggene, hvilket map som skal spilles og farger på spillere. Klassen
 * rendrer det som vises på skjermen og interakterer opp mot spillmotoren
 * libgdx som vi har brukt til å lage spillet.
 *
 * @author Team Agile
 *
 */

public class RoboRally extends InputAdapter implements Screen {

    public SpriteBatch batch;
    private BitmapFont font;
    public TiledMap map;
    public static TiledMapTileLayer boardLayer, playerLayer, holeLayer, wallLayer, boosterLayer, repairLayer, rotationLayer, laserLayer, flag1, flag2, flag3, startPositions;
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
    public static ArrayList<Color> colors;


    public static ArrayList<Color> getColors() {
        return colors;
    }

    public Robot clientPlayer;

    int boardHeightStartPos = 2;
    int boardHeight = boardHeightStartPos + 11;
    int boardWidth = 16;

    public ArrayList<Wall> allWalls = new ArrayList<>();
    public ArrayList<Laser> allLasers = new ArrayList<>();
    public ArrayList<Booster> allBoosters = new ArrayList<>();
    public ArrayList<Repair> allRepair = new ArrayList<>();
    public ArrayList<Rotation> allRotation = new ArrayList<>();
    public HashMap<Integer, Spawn> spawns = new HashMap<>();
    public String phase = "chooseCards";
    private boolean host;
    public int numberofplayers;

    private CreateGame newGame;
    public CheckEvents checkevent;
    public Texture powerDown, background2;
    public StartGame screen;
    public Boolean anyWin = false;



    public RoboRally(String mapChosen, boolean host){
        this.mapChosen = mapChosen;
        this.host = host;
        newGame = new CreateGame(this);
        checkevent = new CheckEvents(this);
    }
    public RoboRally(String mapChosen, boolean host, StartGame screen){
        this.mapChosen = mapChosen;
        this.host = host;
        newGame = new CreateGame(this);
        checkevent = new CheckEvents(this);
        this.screen = screen;
    }

    public RoboRally(String mapChosen, boolean host, int players, StartGame screen) {
        this.mapChosen = mapChosen;
        this.host = host;
        newGame = new CreateGame(this);
        checkevent = new CheckEvents(this);
        this.numberofplayers = players;
        this.screen = screen;

    }

    @Override
    public void show() {


        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/15green.fnt"));
        colors = new ArrayList<>(Arrays.asList(Color.WHITE,Color.GREEN, Color.LIGHT_GRAY,  Color.FIREBRICK , Color.ORANGE, Color.LIME, Color.YELLOW,  Color.FOREST));
        background2 = new Texture("background2.png");
        powerDown = new Texture("power_down.png");
        camera = new OrthographicCamera();
        viewport = new FitViewport(29,14);
        font_cam = new OrthographicCamera();
        font_cam.setToOrtho(false, 1339,750);
        newGame.initalize();

        render = new OrthogonalTiledMapRenderer(map , 1/300f);

        if(host) {
            try {
                GameServer server = new GameServer(numberofplayers);
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
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(handler);

        viewport.apply();
        render.setView((OrthographicCamera) viewport.getCamera());
        render.render();

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        drawPlayers(robots, batch);

        batch.draw(background2, 0,0, 29,14);

        if (clientPlayer != null && anyWin == false) {
            clientPlayer.renderCards(batch);
            batch.draw(background2, 0,0, 29,14);
            batch.setProjectionMatrix(font_cam.combined);
            clientPlayer.renderPriority(batch);
            batch.draw(powerDown, 1090, 49, 170, 76);
            batch.setProjectionMatrix(font_cam.combined);
            clientPlayer.initializeHud(batch);
        }
        batch.end();

        if (clientPlayer != null && phase.equals("check") && anyWin == false) {
            checkevent.checkLaserBeams(allLasers);
            checkevent.checkBoosters(robots);
            checkevent.checkHole(robots);
            checkevent.checkRepair(robots);
            checkevent.checkRotate(robots);
            //firelaser
            checkevent.checkrobotStates(robots);
            checkevent.checkIfSomeoneDead(robots);
            checkevent.checkFlags(robots);
            checkevent.allFlagsTaken(robots);
            phase = "pickCards";
        }

        if (anyWin) {
            Gdx.gl.glClearColor(0.5f, 0.5f, 1, 1);
            Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);


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

    @Override
    public void hide() {

    }

    public static TiledMapTileLayer getLaserLayer() {
        return laserLayer;
    }


}
