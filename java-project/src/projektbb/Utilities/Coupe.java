package projektbb.Utilities;

import java.io.Serializable;
import java.util.UUID;

public class Coupe extends Cars implements Serializable {

    protected String roof;


    public Coupe(UUID uuid, String name, String color, String condition, double price, String roof){
        super(uuid,name,color,condition,price);
        this.roof=roof;

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
