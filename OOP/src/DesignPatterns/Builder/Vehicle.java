package DesignPatterns.Builder;

public class Vehicle implements Cloneable
{
    private int doors;
    private int wheels;
    private int seats;
    private int enginePower;
    private int trunkCapacity;

    public Vehicle() {

    }

    public Vehicle(int doors, int wheels) {
        this.doors = doors;
        this.wheels = wheels;
    }

    public Vehicle(int doors, int wheels, int seats) {
        this(doors, wheels);
        this.seats = seats;
    }

    public Vehicle(int doors, int wheels, int seats, int enginePower) {
        this(doors, wheels, seats);
        this.enginePower = enginePower;
    }

    public Vehicle(int doors, int wheels, int seats, int enginePower, int trunkCapacity) {
        this(doors, wheels, seats, enginePower);
        this.trunkCapacity = trunkCapacity;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(int trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }

    public Vehicle duplicate() throws CloneNotSupportedException {
        return (Vehicle) clone();
    }
}
