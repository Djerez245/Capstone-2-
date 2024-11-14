package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface extends UserInterfaceMethods {


    Scanner scanner = new Scanner(System.in);

    public void runApp() {

        boolean deliOpen = true;
        while (deliOpen) {
            DisplayScreens.displayHeader();
            DisplayScreens.displayHomeScreen();
            try {
                int homeInput = scanner.nextInt();
                scanner.nextLine();
                switch (homeInput) {
                    case 1 -> orderMenu();
                    case 2 -> {
                        deliOpen = false;
                        System.out.println("Thank you! Come again!");
                    }
                    default -> System.out.println("Invalid input. Please select 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }



    public void orderMenu() {
        boolean ordering = true;
        while (ordering) {
            try {
                DisplayScreens.displayHeader();
                DisplayScreens.displayOrderScreen();
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1 -> addSandwich();
                    case 2 -> addDrink();
                    case 3 -> addChips();
                    case 4 -> checkout(order);
                    case 0 -> {
                        ordering = false;
                        System.out.println("Going back home....");
                    }
                    default -> System.out.println("Invalid input. Please select 1 - 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

}
