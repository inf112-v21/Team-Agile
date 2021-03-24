package inf112.skeleton.app.network.Packets.Events;

public class RotationEvent {
    public int id;
    public int rotation;

    public RotationEvent() {

    }

    public RotationEvent(int index, int move) {
        this.id = index;
        this.rotation = move;
    }
}


