package projektbb.Utilities;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.Serializable;
import java.util.UUID;


public class Convertible<function> extends Cars implements  Serializable {

    private double topSpeed;
    

    public Convertible(UUID uuid, String name, String color, String condition, double price) {
        super(uuid, name, color, condition, price);

    }

    public Convertible(UUID uuid, String name, String color, String condition, double price,double topSpeed) {
        super(uuid, name, color, condition, price);
        this.topSpeed=topSpeed;
    }


    @Override
    public boolean Drivable() {
        if (condition == "Drivable") {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Info() {
        System.out.println("Name:" + name);
        System.out.println("Color:" + color);

        System.out.println("Top speed:" + topSpeed);


    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }
}



