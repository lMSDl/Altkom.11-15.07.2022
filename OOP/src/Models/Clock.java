package Models;

public class Clock {

    private ClockHand hourClockHand;
    private ClockHand minuteClockHand;
    private ClockHand secondClockHand;

    public Clock(ClockHand hourClockHand, ClockHand minuteClockHand, ClockHand secondClockHand) {
        this.hourClockHand = hourClockHand;
        this.minuteClockHand = minuteClockHand;
        this.secondClockHand = secondClockHand;
    }
}
