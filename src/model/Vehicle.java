package model;

public abstract class Vehicle {
    public static final int BEGIN_DISTANCE = 0;
    public static final boolean DEFAULT_STATUS = true;
    private String licensePlate;
    private String driverName;
    private int distance = BEGIN_DISTANCE;
    private boolean isAvaiable= DEFAULT_STATUS;
    public Vehicle(String licensePlate, String driverName) {
        this.licensePlate = licensePlate;
        this.driverName = driverName;
    }

    public int getDistance() {
        return distance;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getDriverName() {
        return driverName;
    }

    public boolean getStatus() {
        return isAvaiable;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setStatus(boolean avaiable) {
        isAvaiable = avaiable;
    }
    public abstract int getRevenue();
}
