package View;

import model.*;
import service.VehicleManage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static VehicleManage toan=new VehicleManage();
    static Comparator<Vehicle> comparator=new IncreaseSortByRevenueVehicle();
    public static void main(String[] args) {
        List<Vehicle> list=new ArrayList<>();
        toan.setVehicleList(list);
        ProxyManage manage=new ProxyManage(toan,"manage");
        ProxyManage client=new ProxyManage(toan,"client");
        Thread t1=new Thread(client);
        t1.start();
        Vehicle tax1=new Taxi("A1234","Mừng");
        Vehicle tax2=new Taxi("A1235","thanh");
        Vehicle bike1=new Motorbike("B2331","hieu");
        Vehicle bike2=new Motorbike("B2341","hieu2");
        manage.addNew(tax1);
        manage.addNew(tax2);
        manage.addNew(bike1);
        manage.addNew(bike2);




    }
}
