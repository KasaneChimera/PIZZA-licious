package com.pluralsight;

import java.util.ArrayList;

public class Pizza {

    private int size;
    private String crust;
    private boolean stuffedCrust;

    private ArrayList<Topping> toppings = new ArrayList<>();

    public Pizza(int size, String crust, boolean stuffedCrust) {

        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {

        double total = 0;

        switch (size) {

            case 8:
                total = 8.50;
                break;

            case 12:
                total = 12.00;
                break;

            case 16:
                total = 16.50;
                break;
        }

        if (stuffedCrust) {
            total += 2.00;
        }

        for (Topping topping : toppings) {

            total += topping.getPrice(size);
        }

        return total;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(size)
                .append("\" Pizza ")
                .append(crust)
                .append(" crust\n");

        for (Topping topping : toppings) {
            sb.append("- ").append(topping).append("\n");
        }

        return sb.toString();
    }
}