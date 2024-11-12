package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintReceipt {

    Order order;

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter fmtDateTime = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
    FileWriter fw = new FileWriter("capstone-2-deli-icous/Receipts/" + dateTime.format(fmtDateTime) + ".txt", true);
    BufferedWriter bufferedWriter = new BufferedWriter(fw);

    String receiptHeader = ("""
            =================================
                        RECEIPT
            =================================
            """);

    public PrintReceipt() throws IOException {
    }

    public void printReceiptToFile(Order o) throws IOException {
        bufferedWriter.write(receiptHeader);
        for (int i = 0; i < o.orders.size(); i++) {
            bufferedWriter.write(o.orders.get(i).toStringForCsv());
            bufferedWriter.newLine();
        }
        bufferedWriter.write(String.valueOf(o.getPrice()));
        bufferedWriter.close();
        System.out.println("\nTHANK YOU HAVE A GOOD DAY!");

    }
}


