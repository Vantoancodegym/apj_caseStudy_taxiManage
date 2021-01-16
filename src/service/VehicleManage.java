package service;
import model.Manage;
import model.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VehicleManage implements Manage {
    private static List<Vehicle> vehicleList;
    public void setVehicleList(List<Vehicle> vehicleList) {
        VehicleManage.vehicleList = vehicleList;
    }
    @Override
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }
    @Override
    public  List<Vehicle> getListAvaiable(){
        List<Vehicle> list=new ArrayList<>();
        for (Vehicle v:vehicleList) {
            if (v.getStatus()) list.add(v);
        }
        return list;
    }
    @Override
    public void addNew(Vehicle vehicle){
        vehicleList.add(vehicle);
    }
    @Override
    public String editName(String licensePlate, String name){
        for (Vehicle v:vehicleList) {
            if (v.getLicensePlate().equals(licensePlate)){
                if (v.getStatus()) {
                    v.setDriverName(name);
                    return "Đã thay lái xe thành công";
                }else return "Xe đang chạy bạn không thể thay lái xe";
            }
        }
        return "Biển số không tồn tại";
    }
    @Override
    public String remove(String licensePlate){
        for (Vehicle v:vehicleList) {
            if (v.getLicensePlate().equals(licensePlate)){
                if (v.getStatus()) {
                    vehicleList.remove(v);
                    return "Đã xóa thành công";
                }else return "Xe đang chạy không thể xóa";
            }
        }
        return "Biển số xe không tồn tại";
    }
    @Override
    public void takeAVehicle(int distance, String type){
        for (Vehicle v:vehicleList) {
            if (Method.getClassName(v).equals(type)){
                if (v.getStatus()){
                v.setStatus(false);
                v.setDistance(distance);
                vehicleList.remove(v);
                vehicleList.add(v);
                    System.out.println("Đặt xe thành công "+v);
                return;
                }
            }
        }
        System.out.println("Tất cả các xe "+type+ " đều bận");
    }
    @Override
    public void releaseVehicle(){
        for (Vehicle v:vehicleList) {
            v.setStatus(true);
        }
    }
    @Override
    public List<Vehicle> sort(Comparator<Vehicle> comparator){
        List<Vehicle> list=new ArrayList<>();
        for (Vehicle v:vehicleList) {
            list.add(v);
        }
        Collections.sort(list,comparator);
       return list;
    }
    @Override
    public void show(List<Vehicle> list) {
            for (Vehicle v:list) {
                System.out.println(v.toString());
            }
    }

}
