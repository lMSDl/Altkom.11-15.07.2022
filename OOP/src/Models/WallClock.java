package Models;

public class WallClock extends Clock {

    private Hanger hanger;

    public  WallClock() {
        //var hourClockHand = new ClockHand();
        //var minuteClockHand = new ClockHand();
        //var secondClockHand = new ClockHand();
        //super(new ClockHand(), new ClockHand(), new ClockHand());
        //this.hanger = new Hanger();
        this(new ClockHand(), new ClockHand(), new ClockHand(), new Hanger());
    }

    public WallClock(ClockHand hourClockHand, ClockHand minuteClockHand, ClockHand secondClockHand, Hanger hanger ) {
        super(hourClockHand, minuteClockHand, secondClockHand);
        this.hanger = hanger;
    }

    public float getPrice() {
        return hanger.getPrice() + super.getPrice();
    }

    public String toString(){
        return getInfo() + " (" + super.toString() + ")";
    }
}
