package inf112.skeleton.app.network.Packets.Events;

public class MoveEvent {

    public int id;
    public int move;


    public MoveEvent() {

    }
    public MoveEvent(int index ,int move) {
        this.id = index;
        this.move = move;
    }

    public int toInt(String move) {
        return Integer.parseInt(move);
    }
}
