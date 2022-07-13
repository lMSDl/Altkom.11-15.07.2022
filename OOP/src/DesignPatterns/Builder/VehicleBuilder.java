package DesignPatterns.Builder;

public class VehicleBuilder {

    private Vehicle vehicle = new Vehicle();

    public VehicleBuilder setDoors(int doors) {
        vehicle.setDoors(doors);
        return  this;
    }

    public VehicleBuilder setWheels(int wheels) {
        vehicle.setWheels(wheels);
        return  this;
    }

    public VehicleBuilder setSeats(int seats) {
        vehicle.setSeats(seats);
        return  this;
    }

    public VehicleBuilder setEnginePower(int enginePower) {
        vehicle.setEnginePower(enginePower);
        return  this;
    }

    public VehicleBuilder setTrunkCapacity(int trunkCapacity) {
        vehicle.setTrunkCapacity(trunkCapacity);
        return  this;
    }

    public Vehicle build() {
        try {
            return  vehicle.duplicate();
        } catch (CloneNotSupportedException e) {
            return  null;
        }
    }
}
