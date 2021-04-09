package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.map.Laser;
import inf112.skeleton.app.map.Spawn;
import inf112.skeleton.app.map.Wall;

import java.util.ArrayList;

public class CreateGame {


    private RoboRally game;


    public CreateGame(RoboRally game) {
        this.game = game;
    }

    public void initalize() {
        TmxMapLoader loader = new TmxMapLoader();
        game.map = loader.load("assets/maps/" + game.mapChosen);

        //Layers initialize
        game.boardLayer = (TiledMapTileLayer) game.map.getLayers().get("BaseLayer");
        game.playerLayer = (TiledMapTileLayer) game.map.getLayers().get("Player");
        game.holeLayer = (TiledMapTileLayer) game.map.getLayers().get("Holes");
        game.wallLayer = (TiledMapTileLayer) game.map.getLayers().get("Walls");
        game.laserLayer = (TiledMapTileLayer) game.map.getLayers().get("Laser");
        game.startPositions = (TiledMapTileLayer) game.map.getLayers().get("StartPositions");


        game.flag1 = (TiledMapTileLayer) game.map.getLayers().get("Flag1");
        game.flag2 = (TiledMapTileLayer) game.map.getLayers().get("Flag2");
        game.flag3 = (TiledMapTileLayer) game.map.getLayers().get("Flag3");

        game.deck = new Deck();
        game.players = new ArrayList<>();
        game.robots = new ArrayList<>();

        registerSpawns();
        registerWallsAndLasers();
    }

    public void registerSpawns() {
        for (int i = 0; i < game.boardWidth; i++) {
            for (int j = 0; j < game.boardHeight; j++) {
                TiledMapTileLayer.Cell spawntile = game.startPositions.getCell(i, j);
                if (spawntile != null) {
                    if (spawntile.getTile().getId() == Spawn.spawn1) {
                        game.spawns.put(0, new Spawn(new Vector2(i, j)));
                    }
                    if (spawntile.getTile().getId() == Spawn.spawn2) {
                        game.spawns.put(1, new Spawn(new Vector2(i, j)));
                    }
                    if (spawntile.getTile().getId() == Spawn.spawn3) {
                        game.spawns.put(2, new Spawn(new Vector2(i, j)));
                    }
                    if (spawntile.getTile().getId() == Spawn.spawn4) {
                        game.spawns.put(3, new Spawn(new Vector2(i, j)));
                    }
                    if (spawntile.getTile().getId() == Spawn.spawn5) {
                        game.spawns.put(4, new Spawn(new Vector2(i, j)));
                    }
                    if (spawntile.getTile().getId() == Spawn.spawn6) {
                        game.spawns.put(5, new Spawn(new Vector2(i, j)));
                    }
                    if (spawntile.getTile().getId() == Spawn.spawn7) {
                        game.spawns.put(6, new Spawn(new Vector2(i, j)));
                    }
                    if (spawntile.getTile().getId() == Spawn.spawn8) {
                        game.spawns.put(7, new Spawn(new Vector2(i, j)));
                    }

                }
            }
        }

    }
    public void registerWallsAndLasers(){
        // register all walls created in the map design
        for(int i = 0; i < game.boardWidth; i++){
            for(int j = 0; j < game.boardHeight; j++){
                TiledMapTileLayer.Cell wallTile = game.wallLayer.getCell(i,j);
                if (wallTile != null){
                    int wallid = wallTile.getTile().getId();
                    if (wallid == Laser.laserSOUTH || wallid == Laser.laserWEST || wallid == Laser.laserEAST || wallid == Laser.doubleLaserEAST) {
                        game.allLasers.add(new Laser(new Vector2(i,j), wallTile.getTile().getId()));
                    }
                    game.allWalls.add(new Wall(new Vector2(i,j), wallTile.getTile().getId()));
                }
            }
        }

        // register of outer vertical walls in map
        for(int i = game.boardHeightStartPos; i <= game.boardHeight; i++){
            game.allWalls.add(new Wall(new Vector2(game.boardWidth,i), Wall.outerWallEAST));
            game.allWalls.add(new Wall(new Vector2(0, i), Wall.outerWallWEST));
        }

        // register of outer horizontal walls in map
        for(int i = 0; i <= game.boardWidth; i++){
            game.allWalls.add(new Wall(new Vector2(i,game.boardHeightStartPos), Wall.outerWallSOUTH));
            game.allWalls.add(new Wall(new Vector2(i,game.boardHeight), Wall.outerWallNORTH));
        }

    }
}
