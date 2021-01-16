package service;

import model.CompareVehicle;
import model.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VehicleManage {
    private static List<Vehicle> vehicleList;
    public void addNew(Vehicle vehicle){
        vehicleList.add(vehicle);
    }

    public static void setVehicleList(List<Vehicle> vehicleList) {
        VehicleManage.vehicleList = vehicleList;
    }

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
    public void takeAVehicle(int distance, String type){
        for (Vehicle v:vehicleList) {
            if (Method.getClassName(v).equals(type)){
                if (v.getStatus()){
                v.setStatus(false);
                v.setDistance(distance);
                vehicleList.remove(v);
                vehicleList.add(v);
                    System.out.println("Đặt xe thành công");
                return;
                }
            }
        }
        System.out.println("Tất cả các xe đều bận");
    }
    public void ReleaseVehicle(){
        for (Vehicle v:vehicleList) {
            v.setStatus(true);
        }

    }
    public List<Vehicle> getNewList(){
        List<Vehicle> newList=new ArrayList<>();
        for (Vehicle v:vehicleList) {
            newList.add(v);
        }
        return newList;
    }
    public void sortAndShow(Comparator<Vehicle> comparator){
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
    public  void showAvaiable(){
        for (Vehicle v:vehicleList) {
            if (v.getStatus()) System.out.println("type : "+ Method.getClassName(v)+
                    "\t licensePlate: "+v.getLicensePlate()+ "\t Drive: "+v.getDriverName());
        }
    }
}
