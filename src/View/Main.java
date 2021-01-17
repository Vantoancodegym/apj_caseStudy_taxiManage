package View;

import model.*;
import service.*;
import storage.ReadAndWrite;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String TAXI_TYPE = "Taxi";
    public static final String MOTORBIKE_TYPE = "Motorbike";
    public static VehicleManage vehicleManage=VehicleManage.getInstance();
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        File saveFile= ReadAndWrite.creatNewFile(VehicleManage.FILE_NAME);
        Object obj=ReadAndWrite.readFile(VehicleManage.FILE_NAME);
        List<Vehicle> list;
        list=(obj==null)?new ArrayList<>():((List<Vehicle>)obj);
        ProxyManage manage=new ProxyManage(vehicleManage, Position.MANAGE);
        ProxyManage client=new ProxyManage(vehicleManage,Position.CLIENT);
        Thread thread=new Thread(client);
        thread.start();
        manage.setVehicleList(list);
        int choice;
        do {
            System.out.println("--- Client ---");
            System.out.println("1. Hiện thị danh sách xe đang rảnh");
            System.out.println("2. Đặt xe tự động");
            System.out.println("--- Manage ---");
            System.out.println("3. Thêm mới");
            System.out.println("4. Thay lái xe");
            System.out.println("5. Xóa");
            System.out.println("6. Sắp xếp và hiện thị theo thứ tự doanh số tăng dần");
            System.out.println("7. Sắp xếp và hiện thị theo thứ tự doanh số giảm dần");
            System.out.println("8. Hiển thị top 3 có doanh thu cao nhât");
            System.out.println("9. Hiển thị top 3 có doanh thu thấp nhât");
            System.out.println("10. Hiển thị toàn bộ danh sách");
            System.out.println("0. Thoát chương trình");
            System.out.println("--------------------");
            choice= scanner.nextInt();
            switch (choice){
                case 1:
                    client.show(client.getListAvaiable());
                    break;
                case 2:
                    takeAVehicle(client);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 0:
                    System.exit(0);
            }
        }while (choice!=0);
    }

    private static void takeAVehicle(ProxyManage client) {
        System.out.println("Nhập khoảng cách cần đi");
        int distance=scanner.nextInt();
        int type;
        do {
            System.out.println("Chọn loại phương tiện: 1. Taxi 2.Xe ôm");
            type=scanner.nextInt();
        }while (type!=1&&type!=2);
        if (type==1) client.takeAVehicle(distance, TAXI_TYPE);
        else client.takeAVehicle(distance, MOTORBIKE_TYPE);
    }
}
