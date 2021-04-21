package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.map.*;

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
        RoboRally.boardLayer = (TiledMapTileLayer) game.map.getLayers().get("BaseLayer");
        RoboRally.playerLayer = (TiledMapTileLayer) game.map.getLayers().get("Player");
        RoboRally.holeLayer = (TiledMapTileLayer) game.map.getLayers().get("Holes");
        RoboRally.wallLayer = (TiledMapTileLayer) game.map.getLayers().get("Walls");
        RoboRally.laserLayer = (TiledMapTileLayer) game.map.getLayers().get("Laser");
        RoboRally.startPositions = (TiledMapTileLayer) game.map.getLayers().get("StartPositions");
        RoboRally.boosterLayer = (TiledMapTileLayer) game.map.getLayers().get("Boostere");
        RoboRally.repairLayer = (TiledMapTileLayer) game.map.getLayers().get("Repair");
        RoboRally.rotationLayer = (TiledMapTileLayer) game.map.getLayers().get("Rotation");

        RoboRally.flag1 = (TiledMapTileLayer) game.map.getLayers().get("Flag1");
        RoboRally.flag2 = (TiledMapTileLayer) game.map.getLayers().get("Flag2");
        RoboRally.flag3 = (TiledMapTileLayer) game.map.getLayers().get("Flag3");

        game.deck = new Deck();
        game.players = new ArrayList<>();
        game.robots = new ArrayList<>();

        registerSpawns();
        registerWallsAndLasers();
        registerBoosters();
        registerRepairTiles();
    }

    public void registerSpawns() {
        for (int i = 0; i < game.boardWidth; i++) {
            for (int j = 0; j < game.boardHeight; j++) {
                TiledMapTileLayer.Cell spawntile = RoboRally.startPositions.getCell(i, j);
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
                TiledMapTileLayer.Cell wallTile = RoboRally.wallLayer.getCell(i,j);
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

    public void registerRepairTiles() {
        for (int i = 0; i < game.boardWidth + 1; i++) {
            for ( int j = 0; j < game.boardHeight + 1; j++ ) {
                TiledMapTileLayer.Cell repairTile = RoboRally.repairLayer.getCell(i, j);
                if (repairTile != null){
                    int repairId = repairTile.getTile().getId();
                    if(repairId == Repair.repairOneHealth || repairId == Repair.repairTwoHealth){
                        game.allRepair.add(new Repair(new Vector2(i,j), repairTile.getTile().getId()));
                    }
                }
            }
        }
    }

    public void registerBoosters() {
        for (int i = 0; i < game.boardWidth + 1; i++) {
            for (int j = 0; j < game.boardHeight + 1; j++) {
                TiledMapTileLayer.Cell boosterTile = RoboRally.boosterLayer.getCell(i,j);
                if (boosterTile != null){
                    int boosterId = boosterTile.getTile().getId();
                    if(boosterId == Booster.UP) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.NORTH, 1, 0));
                    }
                    if(boosterId == Booster.DOWN) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.SOUTH, 1, 0));
                    }
                    if(boosterId == Booster.LEFT) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.WEST, 1, 0));
                    }
                    if(boosterId == Booster.RIGHT) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.EAST, 1, 0));
                    }
                    if(boosterId == Booster.LEFTDOWN) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.SOUTH, 1, 90));
                    }
                    if(boosterId == Booster.RIGHTDOWN) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.SOUTH, 1, -90));
                    }
                    if(boosterId == Booster.UPP) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.NORTH, 2, 0));
                    }
                    if(boosterId == Booster.DOWNN) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.SOUTH, 2, 0));
                    }
                    if(boosterId == Booster.LEFTT) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.WEST, 2, 0));
                    }
                    if(boosterId == Booster.DOWNLEFT) {
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.WEST, 2, 0));
                    }
                    if(boosterId == Booster.LEFTUPUP) {
                        //game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.NORTH, 2, 0));
                        game.allBoosters.add(new Booster(new Vector2(i,j), DirectionEnum.NORTH, 2, -90));
                    }
                }
            }
        }
    }



}
