package Models;

import java.util.Random;

public class ClockHand extends Product {

    public ClockHand(String name) {
        super(name);
    }

    public int getPosition() {
        return new Random().nextInt(0, 360);
    }
}
