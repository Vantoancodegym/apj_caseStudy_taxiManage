package service;

import model.Motorbike;
import model.Taxi;
import model.Vehicle;
import model.VehicleTpye;

public class VehicleFactory {
    public static final Vehicle getVehicle(VehicleTpye type,String name,String licensePlate){
        switch (type){
            case Taxi:
                return new Taxi(licensePlate,name);
            case Motorbike:
                return new Motorbike(licensePlate,name);
            default:
                throw new IllegalArgumentException("Phương tiện không được hỗ trợ");
        }
    }
}
