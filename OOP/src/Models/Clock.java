package Models;

public class Clock extends CraftedProduct {

    private final ClockHand hourClockHand;
    private ClockHand minuteClockHand;
    private ClockHand secondClockHand;

    public Clock(String name, ClockHand hourClockHand, ClockHand minuteClockHand, ClockHand secondClockHand) {
        super(name);
        this.hourClockHand = hourClockHand;
        this.minuteClockHand = minuteClockHand;
        this.secondClockHand = secondClockHand;
    }

    public float getPrice() {
        //hourClockHand.addToPrice(123f);
        return super.getPrice() + hourClockHand.getPrice() + minuteClockHand.getPrice() + secondClockHand.getPrice();
    }
}
