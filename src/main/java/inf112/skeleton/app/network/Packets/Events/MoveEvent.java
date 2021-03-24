package inf112.skeleton.app.network.Packets;

public class MoveEvent {

    public int id;
    public String move;


    public MoveEvent() {

    }
    public MoveEvent(int index ,String move) {
        this.id = index;
        this.move = move;
    }

    public int toInt(String move) {
        return Integer.parseInt(move);
    }
}
