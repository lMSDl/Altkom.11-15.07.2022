package Models;

public /*abstract*/ class AnalogClock extends Clock {

    private final ClockHand hourClockHand;
    private ClockHand minuteClockHand;
    private ClockHand secondClockHand;

    public AnalogClock(String name, ClockHand hourClockHand, ClockHand minuteClockHand, ClockHand secondClockHand) {
        super(name);
        this.hourClockHand = hourClockHand;
        this.minuteClockHand = minuteClockHand;
        this.secondClockHand = secondClockHand;
    }

    public float getPrice() {
        //hourClockHand.addToPrice(123f);
        return super.getPrice() + hourClockHand.getPrice() + minuteClockHand.getPrice() + secondClockHand.getPrice();
    }

    public int getTime() {
        //tak wiem - bez sensu
        return hourClockHand.getPosition() + minuteClockHand.getPosition() + secondClockHand.getPosition();
    }
}
