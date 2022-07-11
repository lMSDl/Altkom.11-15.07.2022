package Models;

public class WallClock extends Clock {

    public  WallClock() {
        //var hourClockHand = new ClockHand();
        //var minuteClockHand = new ClockHand();
        //var secondClockHand = new ClockHand();
        super(new ClockHand(), new ClockHand(), new ClockHand());
    }

    public WallClock(ClockHand hourClockHand, ClockHand minuteClockHand, ClockHand secondClockHand) {
        super(hourClockHand, minuteClockHand, secondClockHand);
    }
}
