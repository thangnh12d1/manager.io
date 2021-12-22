package Main;

import IO.Check_Duplicate;
import IO.File_Factory;
import IO.Index;
import IO.Input;
import Model.Gio_Hang;
import Model.San_Pham;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Quan_Ly_Gio_Hang 
{    
    public static ArrayList<Gio_Hang> arr = new ArrayList<>();
    
    public static void Start() throws IOException, FileNotFoundException, ClassNotFoundException
    {         
        System.out.println("1 : View cart list.");
        System.out.println("2 : Add new Cart.");
        System.out.println("3 : Delete Cart.");
        System.out.println("4 : Find Cart.");
        System.out.println("5 : Save cart list to File.");
        System.out.println("6 : Exit.");
        System.out.print("What do you want to do: ");
        int a = Input.Active(6);
        switch(a)
        {
            case 1 : {Show_All(); break;} 
            case 2 : {Add(); break;} 
            case 3 : {Delete(); break;}
            case 4 : {Find(); break;}
            case 5 : {Output_File(); break;}
            case 6 : {break;}  
            default:
                break;
        }     
    }

    public static void Show_All() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        System.out.println("-------------------------------------------------");
        if(arr.isEmpty())
        {
            System.out.println("Cart list is null!");
        }
        else
        {
            for(int i = 0; i < arr.size(); i++)
            {           
                Print_Inf(arr.get(i));                
            }
        }
        System.out.println("-------------------------------------------------");        
        Start();
    }
    
    public static void Add() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        System.out.println("-------------------------------------------------");
// Input      
        System.out.print("-) Enter Cart Id to add: ");
        String id = Input.Id();
        if(!Check_Duplicate.Id(id))
        {
            System.out.print("The Id you entered is identical, please enter it again: ");
            id = Input.Id();
        }
        ArrayList<San_Pham> listProduct = new ArrayList<San_Pham>();
        San_Pham product = new San_Pham();
        boolean stopBuy = false;
        do{
            System.out.println("The product: ");
            System.out.println("1. Coca(10.000)");
            System.out.println("2. Pepsi(10.000)");
            System.out.println("3. Soda(20.000)");
            System.out.print("What do you want to buy: ");
            int numProduct = 0;
            int a = Input.Active(3);
            switch(a)
            {
                case 1 : {                   
                    product.setName("Coca");
                    product.setPrice(10000);
                    listProduct.add(product);
                    break;
                } 
                case 2 : {
                    product.setName("Pepsi");
                    product.setPrice(10000);
                    listProduct.add(product);
                    break;
                } 
                case 3 : {
                    product.setName("Soda");
                    product.setPrice(20000);
                    listProduct.add(product);
                    break;
                }
                
            }
            System.out.println("What do you want to buy more: ");
            System.out.println();
            System.out.println("1. Yes ");  
            System.out.println("2. No ");
            int b = Input.Active(2);
            switch(b)
            {
                case 1 : {stopBuy = false; break;} 
                case 2 : {stopBuy = true; break;}                 
            }       
        }while(!stopBuy);
        
        

        
// Create new Gio_Hang by input information        
        Gio_Hang kh = new Gio_Hang(id,listProduct);
        int billCart = 0;
        billCart = calBill(kh);
        Print_Inf(kh);
// Print total Bill
        kh.getBill();
// Add to list        
        arr.add(kh);   
// Customer to pay
        
// Save        
        System.out.println("[Successfully added to the list!]");
        Save();
        System.out.println("-------------------------------------------------");        
        Start();
    }
            
    public static void Save() throws IOException
    {
        File_Factory.Output(); 
        System.out.println("[Successfully saved the list!]");
        
    }
    
    public static void Print_Inf(Gio_Hang gh)
    {   
        System.out.println("ID: " + gh.getId());
        System.out.println("Cart:  ");
        San_Pham model = new San_Pham();
        ArrayList<San_Pham> listProduct = gh.getList();
        int index = 0;
        System.out.println("Cart:  ");
        while(index < listProduct.size()){
            model = listProduct.get(index);
            System.out.println("Product: " + model.getName());
            index++;
        }
        System.out.println("Total bill:  " + model.getBill());       
        System.out.println();
    }

    public static void payBill(Gio_Hang gh) throws IOException, FileNotFoundException, ClassNotFoundException
    {   
        
        System.out.println("Customer's cash : ");
        int cusCash = Input.Number();
        if(cusCash != 10000 && cusCash != 20000 && cusCash != 50000 && cusCash != 100000 && cusCash != 200000) 
            System.out.print("The money is not valid, please enter it again: ");
        
        System.out.print("The money back for customer: " + (cusCash-gh.getBill()));
    }

    public static int calBill(Gio_Hang gh)
    {
        San_Pham model = new San_Pham();
        int bill = 0;
        ArrayList<San_Pham> listProduct = new ArrayList<San_Pham>();
        listProduct = gh.getList();
        int index = 0;
        while(index < listProduct.size()){
            model = listProduct.get(index);
            if(model.getName() == "Coca"){
                bill += 10000;
            }
            else if(model.getName() == "Pepsi"){
                bill += 10000;
            }
            else if(model.getName() == "Soda"){
                bill += 20000;
            }
            index++;
        }
        return bill;
    }
    
    public static void printBill(Gio_Hang gh){
        San_Pham model = new San_Pham();
        ArrayList<San_Pham> listProduct = new ArrayList<San_Pham>();
        listProduct = gh.getList();
        int index = 0;
        System.out.println("Cart:  ");
        while(index < listProduct.size()){
            System.out.println("Product: " + model.getName());
            index++;
        }
        System.out.println("Total bill:  " + model.getBill());
    }
    


    public static void Delete() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        System.out.println("-------------------------------------------------");
// Input        
        System.out.print("Enter Cart Id to delete: ");
        String id = Input.Id();
        while(Check_Duplicate.Id(id))
        {
            System.out.print("The Id you entered is identical, please enter it again: ");
            id = Input.Id();
        }
// Delete        
        for(int i = 0; i < arr.size(); i++)
        {
            if(id.equals(arr.get(i).getId()))
            {
                arr.remove(i);
                break;
            }
        }
// Save        
        System.out.println("[Successfully delete the Cart!]");
        Save();
        System.out.println("-------------------------------------------------");            
        Start();
    }
    
    
    
    public static void Find() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        
//  Var
        int location;
// Input and Find
        System.out.println("-------------------------------------------------");                
        System.out.print("What you want to search Cart by ID: ");
        System.out.print("Enter Cart Id to find: ");                
                location = Index.by_Id(Input.Id());
                if(location != -1)
                {
                    System.out.println("");
                    Print_Inf(arr.get(location));                    
                }
                else
                {
                    System.out.println("[No Result!]");
                }        
       
        System.out.println("-------------------------------------------------");        
        Start();
    }
    
    public static void Output_File() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        System.out.println("-------------------------------------------------");         
        File_Factory.Output_Text();
        System.out.println("[Successfully saved File!]");
        System.out.println("[File was saved in D:]");
        System.out.println("-------------------------------------------------");    
        Start();
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException 
    {
        File_Factory.Input();         
        Start();
    }
    
}
