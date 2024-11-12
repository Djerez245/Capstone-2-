package com.pluralsight;

import java.util.Scanner;

public class UserInterface extends UserInterfaceMethods {


    Scanner scanner = new Scanner(System.in);

    public void runApp() {
        DisplayScreens.displayHeader();
        DisplayScreens.displayHomeScreen();
        int homeInput = scanner.nextInt();
        scanner.nextLine();
        boolean deliOpen = true;
        while (deliOpen) {
            switch (homeInput){
                case 1 -> orderMenu();
                case 2 -> deliOpen = false;
            }
        }
    }

    public void orderMenu() {
        boolean ordering = true;
        while (ordering) {
            DisplayScreens.displayHeader();
            DisplayScreens.displayOrderScreen();
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1 -> addSandwich();
                case 2 -> addDrink();
                case 3 -> addChips();
                case 4 -> { //checkout();
                }
                case 5 -> ordering = false;
            }
        }
    }
}
