package View;

import model.CompareVehicle;
import model.Motorbike;
import model.Taxi;
import model.Vehicle;
import service.VehicleManage;

import javax.swing.tree.VariableHeightLayoutCache;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static VehicleManage toan=new VehicleManage();
    static Comparator<Vehicle> comparator=new CompareVehicle();
    public static void main(String[] args) {
        List<Vehicle> list=new ArrayList<>();
        toan.setVehicleList(list);
        Vehicle tax1=new Taxi("A1234","Mừng");
        Vehicle tax2=new Taxi("A1235","thanh");
        Vehicle bike1=new Motorbike("B2331","hieu");
        Vehicle bike2=new Motorbike("B2341","hieu2");
        toan.addNew(tax1);
        toan.addNew(tax2);
        toan.addNew(bike1);
        toan.addNew(bike2);
        toan.showAll();
        toan.showAvaiable();
        toan.takeAVehicle(12,"Taxi");
        toan.showAvaiable();
        toan.takeAVehicle(20,"Motorbike");
        toan.showAll();
        System.out.println("-----------------------");
        toan.sortAndShow(comparator);
        System.out.println(toan.remove("A1234"));
        System.out.println(toan.remove("A12"));
        System.out.println(toan.remove("A1235"));

    }
}
