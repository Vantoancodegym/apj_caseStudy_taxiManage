package model;

import service.VehicleManage;

import java.util.Comparator;
import java.util.List;

public class ProxyManage implements Manage,Runnable{
    private VehicleManage vehicleManage;
    private String position;
    public ProxyManage(VehicleManage vehicleManage, String position){
        this.vehicleManage=vehicleManage;
        this.position=position;
    }

    @Override
    public void setVehicleList(List<Vehicle> vehicleList) {
        if (position.equals("manage")) vehicleManage.setVehicleList(vehicleList);
    }

    @Override
    public List<Vehicle> getVehicleList() {
        if (position.equals("manage"))return vehicleManage.getVehicleList();
        return null;
    }

    @Override
    public List<Vehicle> getListAvaiable() {
        if (position.equals("client"))return vehicleManage.getListAvaiable();
        return null;
    }

    @Override
    public void addNew(Vehicle vehicle) {
        if (position.equals("manage"))vehicleManage.addNew(vehicle);
    }

    @Override
    public String editName(String licensePlate, String name) {
        if (position.equals("manage"))return vehicleManage.editName(licensePlate,name);
        return null;
    }

    @Override
    public String remove(String licensePlate) {
        if (position.equals("manage"))return vehicleManage.remove(licensePlate);
        return null;
    }

    @Override
    public void takeAVehicle(int distance, String type) {
        if (position.equals("client")) vehicleManage.takeAVehicle(distance,type);
    }

    @Override
    public void releaseVehicle() {
        if (position.equals("client"))vehicleManage.releaseVehicle();
    }

    @Override
    public List<Vehicle> sort(Comparator<Vehicle> comparator) {
        if (position.equals("manage"))return vehicleManage.sort(comparator);
        return null;
    }

    @Override
    public void show(List<Vehicle> list) throws NullPointerException{
        try {
            vehicleManage.show(list);
        }catch (NullPointerException e){
            System.out.println("Danh sách trống");

        }
    }

    @Override
    public void run() {
        while (true) {
            this.releaseVehicle();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
