package com.pluralsight;

import java.util.ArrayList;

public class Order {

    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<GarlicKnots> garlicKnots = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addGarlicKnots(GarlicKnots knots) {
        garlicKnots.add(knots);
    }

    public double calculateTotal() {

        double total = 0;

        for (Pizza pizza : pizzas) {
            total += pizza.calculatePrice();
        }

        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        for (GarlicKnots knots : garlicKnots) {
            total += knots.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Pizza pizza : pizzas) {
            sb.append(pizza).append("\n");
        }

        for (Drink drink : drinks) {
            sb.append(drink).append("\n");
        }

        for (GarlicKnots knots : garlicKnots) {
            sb.append(knots).append("\n");
        }

        return sb.toString();
    }
}