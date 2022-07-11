package Models;

public abstract class Clock extends CraftedProduct{
    public Clock(String name) {
        super(name);
    }

    public abstract int getTime();
}
