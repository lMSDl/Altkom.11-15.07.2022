package Models;

public class WallClock extends AnalogClock {

    private Hanger hanger;

    public  WallClock(String name) {
        //var hourClockHand = new ClockHand();
        //var minuteClockHand = new ClockHand();
        //var secondClockHand = new ClockHand();
        //super(new ClockHand(), new ClockHand(), new ClockHand());
        //this.hanger = new Hanger();
        this(name, new ClockHand("hour"), new ClockHand("minute"), new ClockHand("second"), new Hanger("hanger"));
    }

    public WallClock(String name, ClockHand hourClockHand, ClockHand minuteClockHand, ClockHand secondClockHand, Hanger hanger ) {
        super(name, hourClockHand, minuteClockHand, secondClockHand);
        this.hanger = hanger;
    }

    public float getPrice() {
        return hanger.getPrice() + super.getPrice();
    }

    public String toString(){
        return getInfo() + " (" + super.toString() + ")";
    }

}
