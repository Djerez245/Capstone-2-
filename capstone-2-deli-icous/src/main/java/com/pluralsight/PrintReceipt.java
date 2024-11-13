package com.pluralsight;

import interfaces.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintReceipt {

    public PrintReceipt() {
    }

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter fmtDateTime = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
    String filename = "Capstone-2-/capstone-2-deli-icous/src/main/resources/receipts/" + dateTime.format(fmtDateTime) + ".txt";
    FileWriter fw;

    {
        try {
            fw = new FileWriter(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedWriter bufferedWriter = new BufferedWriter(fw);

    String receiptHeader = ("""
            =================================
                        RECEIPT
            =================================
            """);


    public void printReceiptToFile(Order o) throws IOException {
        try {
            bufferedWriter.write(receiptHeader);
            for (Item item : o.items) {
                bufferedWriter.write(item.toStringForCsv());
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Total: " + o.getPrice());
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("\nTHANK YOU HAVE A GOOD DAY!");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}


