package inf112.skeleton.app.network;

public class GameEvent {

    //GameEvent object is sent over the network for each move done by each player, for each turn

    //coordinates are sent from clients after each move, then updated on the server and subsequentally
    //broadcasted to all clients, to update the state of the game on all computers
    int x;
    int y;

    //if isAlive is set to False, the connection is still alive but the player is removed from the player list
    boolean isAlive;

    //playerID is the same as outputted from connectionID method for connected clients
    int playerID;

    //the GameEvent provides an update on the current state of the given player
    public GameEvent (int playerID, int x, int y, boolean isAlive) {
        this.playerID = playerID;
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
    }

    /*
    1 klasse Sende parametere for initalisere robot (int x , int y)

    1 klasse oppdatere parametere til robot (int nyx, int nyY , rotation
     */

}
