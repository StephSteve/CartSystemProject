package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
    private HashMap<String, Item> itemCollection;


    TheSystem() {
        // Your code here
        itemCollection = new HashMap<String, Item>();
        if (getClass().getSimpleName().equals("AppSystem")){
            try{
                File inputFile = new File("resources//sample.txt");
                Scanner fileReader = new Scanner(inputFile);
                while(fileReader.hasNext()){
                    String line = fileReader.nextLine();
                    String[] itemInfo = line.split("  ");
                    Item nextItem = new Item(itemInfo[0], itemInfo[1], Double.parseDouble(itemInfo[2]), Integer.parseInt(itemInfo[3]));
                    add(nextItem);
                }
            }catch (FileNotFoundException e){
                System.out.println("No File");

            }
        }
    }
    
    public HashMap<String, Item> getItemCollection(){
        // Your code here
        return this.itemCollection;
    }

    public void setItemCollection(HashMap<String, Item> itemCollection) {
        this.itemCollection = itemCollection;
    }
    
    public Boolean checkAvailability(Item item) {
        // Your code here
        if (item.getQuantity() >= item.getAvailableQuantity()){
            System.out.println("System is unavailable to add " + item.getItemName() + "to the cart. " + "System only has " + item.getAvailableQuantity() + item.getItemName() +"'s");
            return false;
        }
        return true;
    }
    
    public Boolean add(Item item) {
        // Your code here
        if (item == null){
        return false;
    }else if (this.itemCollection.containsValue(item)){
            itemCollection.get(item.getItemName()).setQuantity(item.getQuantity() + 1);
        }else {
        itemCollection.put(item.getItemName(), item);
        return true;
        }
        return false;
    }

    public Item remove(String itemName) {
        // Your code here
        if (itemCollection.containsKey(itemName)){
            Item removed = itemCollection.get(itemName);
            itemCollection.remove(itemName);
        }
        return null;

        }

    public abstract void display();
}



