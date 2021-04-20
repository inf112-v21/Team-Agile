package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.map.Booster;
import inf112.skeleton.app.map.Laser;
import inf112.skeleton.app.map.Wall;
import inf112.skeleton.app.object.Robot;

import java.util.ArrayList;
import java.util.HashMap;

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

        if (laser.getCellId() == Laser.laserSOUTH) {
            for (int i = (int) y; i < game.boardHeight; i++) {
                TiledMapTileLayer.Cell wallTile = game.wallLayer.getCell((int) x, i);
                if (wallTile != null && i > y) {
                    break;
                }
                for (Robot r : game.robots) {
                    if (r.getX() == x && r.getY() == i) {
                        distance = (int) Math.abs(r.getY() - y);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
            }
        }
        if (laser.getCellId() == Laser.laserWEST) {
            for (int i = (int) x; i < game.boardWidth; i++) {
                TiledMapTileLayer.Cell wallTile = game.wallLayer.getCell(i, (int) y);
                if (wallTile != null && i > x) {
                    break;
                }
                for (Robot r : game.robots) {
                    if (r.getX() == i && r.getY() == y) {
                        distance = (int) Math.abs(r.getX() - x);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
            }
        }
        if (laser.getCellId() == Laser.laserEAST) {
            for (int i = (int) x; i > 0; i--) {
                TiledMapTileLayer.Cell wallTile = game.wallLayer.getCell(i, (int) y);
                if (wallTile != null && i < x) {
                    break;
                }
                for (Robot r : game.robots) {
                    if (r.getX() == i && r.getY() == y) {
                        distance = (int) Math.abs(r.getX() - x);
                        robotsDistanceToLaser.put(distance, r);
                    }
                }
            }
        }
        if (laser.getCellId() == Laser.doubleLaserEAST) {
            for (int i = (int) x; i > 0; i--) {
                TiledMapTileLayer.Cell wallTile = game.wallLayer.getCell(i, (int) y);
                if (wallTile != null && i < x) {
                    break;
                }
                for (Robot r : game.robots) {
                    if (r.getX() == i && r.getY() == y) {
                        laserdamage = 2;
                        distance = (int) Math.abs(r.getX() - x);
                        robotsDistanceToLaser.put(distance, r);
                    }
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

    public void checkFlags(ArrayList<Robot> robotliste) {

        for (Robot r : robotliste) {
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

    public void checkHole(ArrayList<Robot> robotliste) {
        for(Robot r : robotliste) {
            if (game.holeLayer.getCell((int) r.getX(), (int) r.getY()) != null) {
                r.setPosition(r.getCheckpoint().x , r.getCheckpoint().y);
            }
        }
    }

    public void allFlagsTaken(ArrayList<Robot> robotliste) {
        for (Robot r : robotliste) {
            if (r.getFlag() == game.flagsToTake) {
                r.renderHud("Player " + r.id + " won the game!\nRestart the game to start again", game.batch, 2);
            }
        }
    }


    public void checkBoosters(ArrayList<Robot> robotliste) {
        for (Robot r : robotliste) {
            Vector2 robotPosition = new Vector2(r.getX(), r.getY());
            for (Booster start : game.allBoosters){
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
