package inf112.skeleton.app.network.Packets;

public class RotationEvent {
    public int id;
    public String rotation;


    public RotationEvent() {

    }
    public RotationEvent(int index ,String move) {
        this.id = index;
        this.rotation = move;
    }

    public int toInt(String rotation) {
        return Integer.parseInt(rotation);
    }
}

