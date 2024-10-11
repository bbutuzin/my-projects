package projektbb.Utilities;

import java.io.Serializable;
import java.util.UUID;

public class SUV extends Cars implements Serializable {

    public SUV(UUID uuid,String name, String color, String condition,double price,String drive) {
        super(uuid,name, color,  condition,price);
        this.drive=drive;
    }
    public String drive;


    @Override
    public boolean Drivable() {
        if(condition=="Drivable"){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void Info() {
        System.out.println("Name:" + name);
        System.out.println("Color:" + color);
    }
}
