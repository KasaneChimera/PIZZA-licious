package com.pluralsight;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public void display() {

        while (true) {

            System.out.println("\n=== PIZZA-licious ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    createOrder();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void createOrder() {

        Order order = new Order();

        while (true) {

            System.out.println("\n--- Order Menu ---");
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addPizza(order);
                    break;

                case 2:
                    addDrink(order);
                    break;

                case 3:
                    order.addGarlicKnots(new GarlicKnots());
                    System.out.println("Garlic knots added.");
                    break;

                case 4:
                    checkout(order);
                    return;

                case 0:
                    System.out.println("Order canceled.");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void addPizza(Order order) {

        System.out.println("Pizza Size (8, 12, 16): ");
        int size = Integer.parseInt(scanner.nextLine());

        System.out.println("Crust Type (thin, regular, thick, cauliflower): ");
        String crust = scanner.nextLine();

        System.out.println("Stuffed crust? (yes/no): ");
        boolean stuffed = scanner.nextLine().equalsIgnoreCase("yes");

        Pizza pizza = new Pizza(size, crust, stuffed);

        while (true) {

            System.out.println("\nAdd topping?");
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Regular topping");
            System.out.println("4) Sauce");
            System.out.println("0) Done");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 0) break;

            System.out.print("Topping name: ");
            String name = scanner.nextLine();

            System.out.print("Extra topping? (yes/no): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("yes");

            switch (choice) {

                case 1:
                    pizza.addTopping(new Topping(name, "meat", extra));
                    break;

                case 2:
                    pizza.addTopping(new Topping(name, "cheese", extra));
                    break;

                case 3:
                    pizza.addTopping(new Topping(name, "regular", extra));
                    break;

                case 4:
                    pizza.addTopping(new Topping(name, "sauce", false));
                    break;
            }
        }

        order.addPizza(pizza);

        System.out.println("Pizza added!");
    }

    public void addDrink(Order order) {

        System.out.println("Drink size (small, medium, large): ");
        String size = scanner.nextLine();

        System.out.println("Flavor: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);

        order.addDrink(drink);

        System.out.println("Drink added!");
    }

    public void checkout(Order order) {

        System.out.println("\n===== RECEIPT =====");

        System.out.println(order);

        System.out.printf("TOTAL: $%.2f\n", order.calculateTotal());

        System.out.println("\n1) Confirm");
        System.out.println("0) Cancel");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {

            ReceiptManager.saveReceipt(order);

            System.out.println("Order completed!");
        }
        else {

            System.out.println("Order canceled.");
        }
    }
}