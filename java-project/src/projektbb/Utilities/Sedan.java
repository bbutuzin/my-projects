package projektbb.Utilities;

import java.io.Serializable;
import java.util.UUID;

public class Sedan extends Cars implements Serializable {
    private String doors;

    public Sedan(UUID uuid,String name,String color,String condition,double price,String doors){
        super(uuid,name,color,condition,price);
        this.doors=doors;
    }



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
        System.out.println("Name:" +name);
        System.out.println("Color:" +color);

    }




}
