package inf112.skeleton.app.network.Packets;

public class CreateRobot {

    public final int x ,y ;

    public CreateRobot() {
        this.x = 5;
        this.y = 5;
    }

    public CreateRobot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
