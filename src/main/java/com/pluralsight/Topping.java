package com.pluralsight;

public class Topping {

    private String name;
    private String type;
    private boolean extra;

    public Topping(String name, String type, boolean extra) {

        this.name = name;
        this.type = type;
        this.extra = extra;
    }

    public double getPrice(int size) {

        double price = 0;

        if (type.equalsIgnoreCase("meat")) {

            if (size == 8) price = 1.00;
            if (size == 12) price = 2.00;
            if (size == 16) price = 3.00;

            if (extra) {

                if (size == 8) price += .50;
                if (size == 12) price += 1.00;
                if (size == 16) price += 1.50;
            }
        }

        else if (type.equalsIgnoreCase("cheese")) {

            if (size == 8) price = .75;
            if (size == 12) price = 1.50;
            if (size == 16) price = 2.25;

            if (extra) {

                if (size == 8) price += .30;
                if (size == 12) price += .60;
                if (size == 16) price += .90;
            }
        }

        return price;
    }

    @Override
    public String toString() {

        if (extra) {
            return "Extra " + name;
        }

        return name;
    }
}