package com.pluralsight;

import com.pluralsight.interfaces.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintReceipt {


    String receiptHeader = ("""
            =================================
                        RECEIPT
            =================================
            """);

    String line = ("\n===============================\n");


    public void printReceiptToFile(Order o) {

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter fmtDateTime = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String filename = "src/main/resources/receipts/" + dateTime.format(fmtDateTime) + ".txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))){
            bufferedWriter.write(receiptHeader);
            for (Item item : o.items) {
                bufferedWriter.write(item.toStringForItems());
                bufferedWriter.newLine();
            }
            bufferedWriter.write(line);
            bufferedWriter.write(String.format("   YOUR TOTAL IS: $%.2f", o.getPrice()));
            bufferedWriter.write(line);
            bufferedWriter.flush();
            System.out.println("\nTHANK YOU HAVE A GOOD DAY!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


