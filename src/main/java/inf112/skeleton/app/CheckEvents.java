package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.map.object.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CheckEvents holder styr på hendelser som gjentas hver runde,
 * og har metoder for å eksekvere disse hendelsene, f.eks
 * avfyring av lasere, å holde styr
 *
 * @author Team Agile
 *
 */

public class CheckEvents {

    private RoboRally game;

    public CheckEvents(RoboRally game) {
        this.game = game;
    }

    public void checkLaserBeams(ArrayList<Laser> lasers) {
        for (Laser l : lasers) {

            dealDamageFromLaser(l);
        }
    }

    private void dealDamageFromLaser(Laser laser) {
        Vector2 laserpos = laser.getLaserPos();

        float x = laserpos.x;
        float y = laserpos.y;
        HashMap<Integer, Robot> robotsDistanceToLaser = new HashMap<>();
        Integer distance;
        int laserdamage = 1;
        boolean last = false;

        if (laser.getCellId() == Laser.laserSOUTH) {
            for (int i = (int) y; i < game.boardHeight; i++) {
                TiledMapTileLayer.Cell wallTile = game.wallLayer.getCell((int) x, i);
                if (wallTile != null && i > y) {
                    last = true;
                }
                for (Robot r : game.robots) {
                    if (r.getX() == x && r.getY() == i) {
                        distance = (int) Math.abs(r.getY() - y);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
                if (last) {
                    break;
                }
            }
        }
        if (laser.getCellId() == Laser.laserWEST) {
            for (int i = (int) x; i < game.boardWidth; i++) {
                TiledMapTileLayer.Cell wallTile = game.wallLayer.getCell(i, (int) y);
                if (wallTile != null && i > x) {
                    last = true;
                }
                for (Robot r : game.robots) {
                    if (r.getX() == i && r.getY() == y) {
                        distance = (int) Math.abs(r.getX() - x);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
                if (last) {
                    break;
                }
            }
        }
        if (laser.getCellId() == Laser.laserEAST) {
            for (int i = (int) x; i > 0; i--) {
                TiledMapTileLayer.Cell wallTile = game.wallLayer.getCell(i, (int) y);
                if (wallTile != null && i < x) {
                    last = true;
                }
                for (Robot r : game.robots) {
                    if (r.getX() == i && r.getY() == y) {
                        distance = (int) Math.abs(r.getX() - x);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
                if (last) {
                    break;
                }
            }
        }
        if (laser.getCellId() == Laser.doubleLaserEAST) {
            for (int i = (int) x; i > 0; i--) {
                TiledMapTileLayer.Cell wallTile = game.wallLayer.getCell(i, (int) y);
                if (wallTile != null && i < x) {
                    last = true;
                }
                for (Robot r : game.robots) {
                    if (r.getX() == i && r.getY() == y) {
                        laserdamage = 2;
                        distance = (int) Math.abs(r.getX() - x);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
                if (last) {
                    break;
                }
            }
        }

        if (!robotsDistanceToLaser.isEmpty()) {
            Integer min = Integer.MAX_VALUE;
            for (Integer key : robotsDistanceToLaser.keySet()) {
                if (key < min) {
                    min = key;
                }
            }
            Robot robot = robotsDistanceToLaser.get(min);
            robot.decreaseRobotHealthpoint(laserdamage);
            robot.renderHud("You lost 1 HP", game.batch, 0);
        }
    }

    public void checkrobotStates(ArrayList<Robot> robotliste) {
        for (Robot r : robotliste) {
            if (game.holeLayer.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.changeState("dead");
                r.decreaseRobotHealthpoint(1);
                r.renderHud("You lost 1 HP", game.batch, 0);
            } else {
                r.changeState("normal");
            }
        }
        allFlagsTaken(game.robots);
    }

    public void checkFlags(ArrayList<Robot> robotList) {

        for (Robot r : robotList) {
            if (game.flag1.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.visitFlag(1);
                r.renderHud("Flag: " + 1 + " was taken by player " + r.id, game.batch, 0);
            } else if (game.flag2.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.visitFlag(2);
                r.renderHud("Flag: " + 2 + " was taken by player " + r.id, game.batch, 0);
            } else if (game.flag3.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.visitFlag(3);
                r.renderHud("Flag: " + 3 + " was taken by player " + r.id, game.batch, 0);
            }
        }
    }

    public void checkHole(ArrayList<Robot> robotList) {
        for(Robot r : robotList) {
            if (game.holeLayer.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.respawn();
            }
        }
    }

    public void checkIfSomeoneDead(ArrayList<Robot> robotliste) {
        for(Robot r : robotliste) {
            if (r.robotHealthPoint == 0) {
                r.respawn();
            }
        }
    }

    public void checkRepair(ArrayList<Robot> robotList) {
        for (Robot r : robotList) {
            Vector2 robotPosition = new Vector2(r.getX(), r.getY());
            for ( Repair repairs : game.allRepair){
                if(robotPosition.x == repairs.getPosition().x && robotPosition.y == repairs.getPosition().y){
                    if (r.getRobotHealthPoint() < 9){ // robot kan ha maks 9hp
                        if(repairs.getCellId() == Repair.repairOneHealth){
                            r.robotHealthPoint += 1;
                        }
                        else if (repairs.getCellId() == Repair.repairTwoHealth){
                            if(r.getRobotHealthPoint() == 8){
                                r.robotHealthPoint += 1; }
                            else{
                                r.robotHealthPoint += 2; }
                        }
                    }
                }
            }
        }
    }

    public void checkRotate(ArrayList<Robot> robotList) {
        for (Robot r : robotList) {
            Vector2 robotPosition = new Vector2(r.getX(), r.getY());
            for ( Rotation rot : game.allRotation){
                if(robotPosition.x == rot.getPosition().x && robotPosition.y == rot.getPosition().y){
                    if(rot.getCellId() == Rotation.rotateLeft){
                        r.rotate(90);
                    }
                    else if (rot.getCellId() == Rotation.rotateRight){
                        r.rotate(-90);
                    }
                }
            }
        }
    }


    public void allFlagsTaken(ArrayList<Robot> robotList) {
        for (Robot r : robotList) {
            if (r.getFlag() == game.flagsToTake) {
                game.screen.setWinGameScreen(r.id);
            }
        }
    }

    public void checkBoosters(ArrayList<Robot> robotList) {
        for (Robot r : robotList) {
            Vector2 robotPosition = new Vector2(r.getX(), r.getY());
            for ( Booster start : game.allBoosters){
                if(robotPosition.x == start.getPosition().x && robotPosition.y == start.getPosition().y) {
                    for(int i = 0 ; i < start.getSpeed(); i++) {
                        for (Booster b : game.allBoosters) {
                            if(robotPosition.x == b.getPosition().x && robotPosition.y == b.getPosition().y) {

                        switch (b.getDirection()) {
                            case SOUTH:
                                r.setPosition(r.getX() , r.getY() - 1);
                                if(b.getTurn() == 90) {
                                    r.rotate(90);
                                }
                                if(b.getTurn() == -90) {
                                    r.rotate(-90);
                                }
                                break;
                            case WEST:
                                r.setPosition(r.getX() - 1 , r.getY());
                                if(b.getTurn() == 90) {
                                    r.rotate(90);
                                }
                                if(b.getTurn() == -90) {
                                    r.rotate(-90);
                                }
                                break;
                            case NORTH:
                                r.setPosition(r.getX() , r.getY() + 1);
                                if(b.getTurn() == 90) {
                                    r.rotate(90);
                                }
                                if(b.getTurn() == -90) {
                                    r.rotate(-90);
                                }
                                break;
                            case EAST:
                                r.setPosition(r.getX() + 1 , r.getY());
                                if(b.getTurn() == 90) {
                                    r.rotate(90);
                                }
                                if(b.getTurn() == -90) {
                                    r.rotate(-90);
                                }
                                break;
                        }
                            }
                        }
                    }
                    break;
                }
            }
        }
    }


}
