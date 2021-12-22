package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Gio_Hang implements Serializable
{
    private String id;    
    private ArrayList<San_Pham> listProduct = new ArrayList<San_Pham>();
    private int bill;
    
    
    public void printBill(){
        San_Pham model = new San_Pham();
        int index = 0;
        System.out.println("Cart:  ");
        while(index < this.listProduct.size()){
            System.out.println("Product: " + model.getName());
            index++;
        }
        System.out.println("Total bill:  " + model.getBill());
    }

    public String getId() {
        return id;
    }

    public ArrayList<San_Pham> getList() {
        return this.listProduct;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBill(){
        return this.bill;
    }

    public Gio_Hang() 
    {
        
    }

    public Gio_Hang(String id,ArrayList<San_Pham> sp) 
    {
        this.id = id;
        this.listProduct = sp;
    }

    @Override
    public String toString() 
    {                                                               
        return this.id + "_" + this.bill;
    }            
}
