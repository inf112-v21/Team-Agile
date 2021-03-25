package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
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
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.network.GameClient;
import inf112.skeleton.app.map.Laser;
import inf112.skeleton.app.map.Wall;
import inf112.skeleton.app.object.InputHandler;
import inf112.skeleton.app.object.Player;
import inf112.skeleton.app.object.Robot;

import java.util.ArrayList;
import java.util.Arrays;

public class RoboRally extends InputAdapter implements ApplicationListener {
    public SpriteBatch batch;
    private BitmapFont font;
    private TiledMap map;
    private static TiledMapTileLayer boardLayer, playerLayer, holeLayer, flagLayer, wallLayer, laserLayer, flag1, flag2, flag3;
    private OrthogonalTiledMapRenderer render;
    private Integer flagsToTake = 4;
    private OrthographicCamera camera, font_cam;
    private ExtendViewport viewport;


    Robot test;

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

    ArrayList<Wall> allWalls = new ArrayList<>();
    ArrayList<Laser> allLasers = new ArrayList<>();

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
        map = loader.load("maps/MapNumber1.tmx");

        //Layers initialize
        boardLayer = (TiledMapTileLayer) map.getLayers().get("BaseLayer");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Holes");
        wallLayer = (TiledMapTileLayer) map.getLayers().get("Walls");
        laserLayer = (TiledMapTileLayer) map.getLayers().get("Laser");

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

        registerWallsAndLasers();

        playerPosition = new Vector2(0, 0);
        robot = new Robot(state1,2,2, "Player 1");

        test = new Robot(state1,2,2);

        InputHandler myhandler = new InputHandler(test, allWalls, allLasers);

        players = new ArrayList<>();

        players.add(test);

        deck.dealOutCards(players);

        test.playerCardstoHand(test.getCards());
        Gdx.input.setInputProcessor(myhandler);
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
        if(clientPlayer != null) {
            batch.setProjectionMatrix(font_cam.combined);
            clientPlayer.initializeHud(batch);
        }


        //robot.draw(batch);
        //robot.renderCards(batch);

        //batch.setProjectionMatrix(font_cam.combined);
        //robot.renderPriority(batch);
        //robot.initializeHud(batch);
 /*
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

         */

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
                r.decreaseRobotHealthpoint(-1);
                r.renderHud("You lost 1 HP", batch, 0);
            } else {
                r.changeState("normal");
            }
        }
        allFlagsTaken(robots);
    }

    public void registerWallsAndLasers(){
        // register all walls created in the map design
        for(int i = 0; i < boardHeight; i++){
            for(int j = 0; j < boardWidth; j++){
                TiledMapTileLayer.Cell wallTile = wallLayer.getCell(i,j);
                if (wallTile != null){
                    int wallid = wallTile.getTile().getId();
                    if (wallid == Laser.laserSOUTH || wallid == Laser.laserWEST || wallid == Laser.laserEAST || wallid == Laser.doubleLaserEAST) {
                        allLasers.add(new Laser(new Vector2(i,j), wallTile, wallTile.getTile().getId()));
                    }
                    allWalls.add(new Wall(new Vector2(i,j), wallTile.getTile().getId()));
                }
            }
        }

        // register of outer vertical walls in map
        for(int i = boardHeightStartPos; i <= boardHeight; i++){
            allWalls.add(new Wall(new Vector2(boardWidth,i), Wall.outerWallEAST));
            allWalls.add(new Wall(new Vector2(0, i), Wall.outerWallWEST));
        }

        // register of outer horizontal walls in map
        for(int i = 0; i <= boardWidth; i++){
            allWalls.add(new Wall(new Vector2(i,boardHeightStartPos), Wall.outerWallSOUTH));
            allWalls.add(new Wall(new Vector2(i,boardHeight), Wall.outerWallNORTH));
        }

        //for(Wall wall : allWalls){
        //    System.out.println("Position: " + wall.getWallPos().x);
       // }

    }

    public void checkFlags(ArrayList<Robot> robotliste) {
        for(Robot r : robotliste) {
            if (flag1.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.visitFlag(1);
                r.renderHud("Flag: " + 1 + " was taken by player " + r.id, batch, 0);
            } else if (flag2.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.visitFlag(2);
                r.renderHud("Flag: " + 2 + " was taken by player " + r.id, batch, 0);
            } else if (flag3.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.visitFlag(3);
                r.renderHud("Flag: " + 3 + " was taken by player " + r.id, batch, 0);
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
                r.renderHud("Player " + r.id + " won the game!\nRestart the game to start again", batch, 2);
            }
        }
    }
      /*
    public void allFlagsTaken(ArrayList<Robot> robots) {
                if (player.getFlag().equals(flagsToTake)) {
                player.renderHud("Player " + player.getName() + " won the game!\nRestart the game to start again", batch, 2);
                }
            }
    }

       */

    public static TiledMapTileLayer getLaserLayer() {
        return laserLayer;
    }

}
