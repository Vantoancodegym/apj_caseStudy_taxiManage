package model;

public class Motorbike extends Vehicle{

    public static final int PRICE_PER_1_KM = 5;

    public Motorbike(String licensePlate, String driverName) {
        super(licensePlate, driverName);
    }

    @Override
    public int getRevenue() {
        return this.getDistance()* PRICE_PER_1_KM;
    }
}
