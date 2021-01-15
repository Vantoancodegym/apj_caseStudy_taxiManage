package service;

import model.Vehicle;

import java.util.List;

public class VehicleManage {
    private List<Vehicle> vehicleList;
    public VehicleManage(List<Vehicle> vehicleList){
        this.vehicleList=vehicleList;
    }
    public void addNew(Vehicle vehicle){
        vehicleList.add(vehicle);
    }
    public void edit(String licensePlate){

    }
    public void remove(String licensePlate){

    }
    public void takeAVehicle(){

    }
    public void ReleaseVehicle(){

    }
    public List<Vehicle> getNewList(){

    }
}
