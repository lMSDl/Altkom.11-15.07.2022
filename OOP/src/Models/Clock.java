package Models;

public class Clock extends Product {

    private ClockHand hourClockHand;
    private ClockHand minuteClockHand;
    private ClockHand secondClockHand;

    public Clock(ClockHand hourClockHand, ClockHand minuteClockHand, ClockHand secondClockHand) {
        this.hourClockHand = hourClockHand;
        this.minuteClockHand = minuteClockHand;
        this.secondClockHand = secondClockHand;
    }

    public float getPrice() {
        return super.getPrice() + hourClockHand.getPrice() + minuteClockHand.getPrice() + secondClockHand.getPrice();
    }
}
