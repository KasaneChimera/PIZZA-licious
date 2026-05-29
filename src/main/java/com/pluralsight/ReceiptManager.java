package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    public static void saveReceipt(Order order) {

        try {

            File folder = new File("receipts");

            if (!folder.exists()) {
                folder.mkdir();
            }

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

            String fileName =
                    "receipts/" +
                            LocalDateTime.now().format(formatter)
                            + ".txt";

            PrintWriter pw =
                    new PrintWriter(new FileWriter(fileName));

            pw.println("===== PIZZA-licious Receipt =====");
            pw.println();

            pw.println(order);

            pw.printf("TOTAL: $%.2f\n", order.calculateTotal());

            pw.close();

            System.out.println("Receipt saved!");

        }
        catch (Exception e) {

            System.out.println("Error saving receipt:");
            System.out.println(e.getMessage());
        }
    }
}