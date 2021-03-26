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
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
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
import java.util.*;

public class RoboRally extends InputAdapter implements ApplicationListener {
    public SpriteBatch batch;
    private BitmapFont font;
    private TiledMap map;
    private static TiledMapTileLayer boardLayer, playerLayer, holeLayer, flagLayer, wallLayer, laserLayer, flag1, flag2, flag3, startPositions;
    private OrthogonalTiledMapRenderer render;
    private Integer flagsToTake = 4;
    private OrthographicCamera camera, font_cam;
    //private ExtendViewport viewport;
    private FitViewport viewport;
    private String mapChosen;


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

    public ArrayList<Wall> allWalls = new ArrayList<>();
    public ArrayList<Laser> allLasers = new ArrayList<>();
    public HashMap<Integer, Spawn> spawns = new HashMap<>();
    public String gameState = "pickCards";
    private boolean host;


    public RoboRally(String mapChosen){
        this.mapChosen = mapChosen;
        this.host = host;
    }






    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/15green.fnt"));
        colors = new ArrayList<>(Arrays.asList(Color.WHITE,Color.LIGHT_GRAY,  Color.FIREBRICK , Color.ORANGE, Color.LIME, Color.YELLOW, Color.GREEN, Color.FOREST));

        camera = new OrthographicCamera();
        viewport = new FitViewport(29,14);
        font_cam = new OrthographicCamera();
        font_cam.setToOrtho(false, 1339,750);

        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("assets/maps/" + mapChosen);

        //Layers initialize
        boardLayer = (TiledMapTileLayer) map.getLayers().get("BaseLayer");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Holes");
        wallLayer = (TiledMapTileLayer) map.getLayers().get("Walls");
        laserLayer = (TiledMapTileLayer) map.getLayers().get("Laser");
        startPositions = (TiledMapTileLayer) map.getLayers().get("StartPositions");


        flag1 = (TiledMapTileLayer) map.getLayers().get("Flag1");
        flag2 = (TiledMapTileLayer) map.getLayers().get("Flag2");
        flag3 = (TiledMapTileLayer) map.getLayers().get("Flag3");

        render = new OrthogonalTiledMapRenderer(map , 1/300f);


        //Texture texture = new Texture("player.png");
        deck = new Deck();
        players = new ArrayList<>();
        robots = new ArrayList<>();
        registerWallsAndLasers();
        registerSpawns();

        if(host == true) {
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

        if(clientPlayer != null && !clientPlayer.cards.isEmpty()) {
            clientPlayer.renderCards(batch);
            batch.setProjectionMatrix(font_cam.combined);
            clientPlayer.renderPriority(batch);

        }
        if(clientPlayer != null) {
            batch.setProjectionMatrix(font_cam.combined);
            clientPlayer.initializeHud(batch);
        }

        batch.end();

    if(clientPlayer != null && gameState == "check") {
        checkrobotStates(robots);
        checkFlags(robots);
        allFlagsTaken(robots);
        checkLaserBeams(allLasers);
        gameState = "pickCards";
        }

    }
    private void checkLaserBeams(ArrayList<Laser> lasers) {
        for (Laser l : lasers) {
            System.out.println(l);
            dealDamageFromLaser(l);
        }
    }

    private void dealDamageFromLaser(Laser laser) {
        Vector2 laserpos = laser.getLaserPos();
        System.out.println(laserpos);
        float x = laserpos.x;
        float y = laserpos.y;
        HashMap<Integer, Robot> robotsDistanceToLaser = new HashMap<>();
        Integer distance;
        int laserdamage = 1;

        if (laser.getCellId() == Laser.laserSOUTH) {
            for (int i = (int) y; i < boardHeight; i++) {
                for (Robot r: robots) {
                    if (r.getX() == x && r.getY() == i) {
                        distance = (int) Math.abs(r.getY() - y);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
            }
        } else if (laser.getCellId() == Laser.laserWEST) {
            for (int i = (int) x; i < boardWidth; i++) {
                for (Robot r: robots) {
                    if (r.getX() == i && r.getY() == y) {
                        distance = (int) Math.abs(r.getX() - x);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
            }
        } else if (laser.getCellId() == Laser.laserEAST) {
            for (int i = (int) x; i > 0; i--) {
                for (Robot r: robots) {
                    if (r.getX() == i && r.getY() == y) {
                        distance = (int) Math.abs(r.getX() - x);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
            }
        } else if (laser.getCellId() == Laser.doubleLaserEAST) {
            for (int i = (int) x; i > 0; i--) {
                for (Robot r: robots) {
                    if (r.getX() == i && r.getY() == y) {
                        laserdamage = 2;
                        distance = (int) Math.abs(r.getX() - x);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
            }
        } else {
            System.out.println("No players hit by lasers.");
        }

        Integer min = Integer.MAX_VALUE;
        for (Integer key : robotsDistanceToLaser.keySet()) {
            if (key < min) {
                min = key;
            }
        }

        if (!robotsDistanceToLaser.isEmpty()) {
            Robot robot = robotsDistanceToLaser.get(min);
            robot.decreaseRobotHealthpoint(laserdamage);
            robot.renderHud("You lost 1 HP", batch, 0);
        }
    }
    public void checkrobotStates(ArrayList<Robot> robotliste) {
        for(Robot r : robotliste) {
            if (holeLayer.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.changeState("dead");
                r.decreaseRobotHealthpoint(1);
                r.renderHud("You lost 1 HP", batch, 0);
            } else {
                r.changeState("normal");
            }
        }
        allFlagsTaken(robots);
    }

    public void registerSpawns() {
        for(int i = 0; i < boardWidth; i++){
            for(int j = 0; j < boardHeight; j++) {
                TiledMapTileLayer.Cell spawntile = startPositions.getCell(i,j);
                if(spawntile != null) {
                    if(spawntile.getTile().getId() == Spawn.spawn1) {
                        spawns.put(0,new Spawn(new Vector2(i,j)));
                        }
                    if(spawntile.getTile().getId() == Spawn.spawn2) {
                        spawns.put(1,new Spawn(new Vector2(i,j)));
                    }
                    if(spawntile.getTile().getId() == Spawn.spawn3) {
                        spawns.put(2,new Spawn(new Vector2(i,j)));
                    }
                    if(spawntile.getTile().getId() == Spawn.spawn4) {
                        spawns.put(3,new Spawn(new Vector2(i,j)));
                    }
                    if(spawntile.getTile().getId() == Spawn.spawn5) {
                        spawns.put(4,new Spawn(new Vector2(i,j)));
                    }
                    if(spawntile.getTile().getId() == Spawn.spawn6) {
                        spawns.put(5,new Spawn(new Vector2(i,j)));
                    }
                    if(spawntile.getTile().getId() == Spawn.spawn7) {
                        spawns.put(6,new Spawn(new Vector2(i,j)));
                    }
                    if(spawntile.getTile().getId() == Spawn.spawn8) {
                        spawns.put(7,new Spawn(new Vector2(i,j)));
                    }

                    }
                }
            }
    }

    public void registerWallsAndLasers(){
        // register all walls created in the map design
        for(int i = 0; i < boardWidth; i++){
            for(int j = 0; j < boardHeight; j++){
                TiledMapTileLayer.Cell wallTile = wallLayer.getCell(i,j);
                if (wallTile != null){
                    int wallid = wallTile.getTile().getId();
                    if (wallid == Laser.laserSOUTH || wallid == Laser.laserWEST || wallid == Laser.laserEAST || wallid == Laser.doubleLaserEAST) {
                        allLasers.add(new Laser(new Vector2(i,j), wallTile.getTile().getId()));
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

    public static TiledMapTileLayer getLaserLayer() {
        return laserLayer;
    }

}
