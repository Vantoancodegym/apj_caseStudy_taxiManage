package View;

import model.*;
import service.VehicleManage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static VehicleManage toan=VehicleManage.getInstance();
    static Comparator<Vehicle> comparator=new IncreaseSortByRevenueVehicle();
    static Comparator<Vehicle> comparator2=new DecreaseSortByRenvenueVehicle();
    public static void main(String[] args) {
        List<Vehicle> list=new ArrayList<>();
        ProxyManage manage=new ProxyManage(toan,"manage");
        ProxyManage client=new ProxyManage(toan,"client");
        manage.setVehicleList(list);
        Vehicle tax1=new Taxi("A1234","Mừng");
        Vehicle tax2=new Taxi("A1235","thanh");
        Vehicle bike1=new Motorbike("B2331","hieu");
        Vehicle bike2=new Motorbike("B2341","hieu2");
        manage.addNew(tax1);
        manage.addNew(tax2);
        manage.addNew(bike1);
        manage.addNew(bike2);
        client.takeAVehicle(10,"Taxi");
        client.takeAVehicle(20,"Taxi");
        client.takeAVehicle(10,"Motorbike");
        client.takeAVehicle(20,"Motorbike");
        client.releaseVehicle();
        client.releaseVehicle();
        System.out.println("--------");
        manage.show(manage.sort(comparator));
        System.out.println("--------");
        manage.show(client.getListAvaiable());
    }
}
