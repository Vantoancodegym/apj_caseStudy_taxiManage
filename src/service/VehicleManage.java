package service;

import model.CompareVehicle;
import model.Vehicle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VehicleManage {
    private List<Vehicle> vehicleList;
    private Comparator<Vehicle> comparator;
    public VehicleManage(List<Vehicle> vehicleList){
        this.vehicleList=vehicleList;
    }
    public void setComparator(Comparator<Vehicle> comparator) {
        this.comparator = comparator;
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
    public void sortAndShow(){
        List<Vehicle> list=this.getNewList();
        Collections.sort(list,comparator);
        for (Vehicle v:list) {
            System.out.println(v.toString());
        }
    }
    public void showAll(){
        for (Vehicle v:vehicleList) {
            System.out.println(v.toString());
        }
    }
}
