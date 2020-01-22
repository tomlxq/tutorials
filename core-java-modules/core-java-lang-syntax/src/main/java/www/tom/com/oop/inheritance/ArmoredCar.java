package www.tom.com.oop.inheritance;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
@Data
public class ArmoredCar extends Car {
    int bulletProofWindows;
    void remoteStartCar() {
        // this vehicle can be started by using a remote control
    }
    private String model;
    public String getAValue() {
        return super.model;   // returns value of model defined in base class Car
        // return this.model;   // will return value of model defined in ArmoredCar
        // return model;   // will return value of model defined in ArmoredCar
    }
    public static String msg() {
        return "ArmoredCar";
    }
}