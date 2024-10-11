package projektbb.Utilities;


import java.util.UUID;

public abstract class Cars {
    protected UUID uuid;
    protected String name;
    protected String color;
    protected String condition;
    protected double price;

    public Cars(String name, String color, String condition, double price) {

    }

    public abstract boolean Drivable();
    public abstract void Info();

    protected  Cars(UUID uuid,String name,String color,String condition,double price){

        this.uuid=uuid;
        this.name=name;
        this.color=color;
        this.condition=condition;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void setIsDrivable(String condition) {
        this.condition = condition;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}

