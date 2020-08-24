package com.example;

import java.util.HashMap;

public class CartSystem extends TheSystem {
    CartSystem() {
    }

    @Override
    public void display() {
        // Your code here
        HashMap<String, Item> itemCollection = getItemCollection();
        System.out.println("Cart:");
        System.out.format("%-20s %-20s %-10s %-10s %-10s%n", "Name","Description", "Price", "Quantity", "Sub Total");
        final double[] totalSum = {0.0};
        itemCollection.forEach((k, item) ->{
            System.out.format("%-20s %-20s %-10.2f %-10d %-10.2f%n", item.getItemName(), item.getItemDesc(), item.getItemPrice(), item.getQuantity(), (item.getItemPrice() * item.getQuantity()));
            totalSum[0] += item.getItemPrice() * item.getQuantity();
        });
        double tax = totalSum[0] * .05;
        double total = tax + totalSum[0];
        System.out.format("%-20s %-20.2f%n", "Pre-tax Total", totalSum[0]);
        System.out.format("%-20s %-20.2f%n", "Tax", tax);
        System.out.format("%-20s %-20.2f%n", "Total", total);

    }
}
