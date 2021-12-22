package Model;

import java.util.Random;

public class San_Pham extends Gio_Hang{
    private String id;    
    private String name;
    private int price;

    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int pr) {
        this.price = pr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public San_Pham(String id, String name, int price) 
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }public San_Pham() 
    {
    }

    @Override
    public String toString() 
    {                                                               
        return this.id + "_" + this.name + "_" + this.price;
    }            
    
}
