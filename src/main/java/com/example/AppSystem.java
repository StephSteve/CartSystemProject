package com.example;

import java.util.HashMap;

public class AppSystem extends TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        // Your code here
        HashMap<String, Item> itemCollection = getItemCollection();
        System.out.println("AppSystem Inventory:");
        System.out.format("%-20s %-20s %-10s %-10s%n", "Name","Description", "Price", "Available Quantity");
        itemCollection.forEach((n , item) ->{
            System.out.format("%-20s %-20s %-10.2f %-10d%n", item.getItemName(), item.getItemDesc(), item.getItemPrice(), item.getAvailableQuantity());

        });

    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        // Your code here
        HashMap<String, Item> itemCollection = getItemCollection();
        if (item == null){
            return false;
        }else if (itemCollection.containsValue(item)){
            System.out.println(item.getItemName() + " is already in the App System");
            return false;
        }else {
            itemCollection.put(item.getItemName(), item);
            return true;
        }
    }

    public Item reduceAvailableQuantity(String item_name) {
        // Your code here
        HashMap<String, Item> itemCollection = getItemCollection();
        if (itemCollection.containsKey(item_name)){
            Item currentItem = itemCollection.get(item_name);
            itemCollection.get(currentItem.getItemName()).setQuantity(currentItem.getQuantity() -1);
            if(currentItem.getAvailableQuantity() == 0){
                remove(item_name);
            }else{
                itemCollection.replace(item_name, currentItem);
                return currentItem;
            }
        }

        return null;
    }
}
