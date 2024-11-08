import java.util.Scanner;

public class UserInterface {

    UserInterfaceMethods method;

    DisplayScreens display;
    Scanner scanner = new Scanner(System.in);

    public void runApp(){
        DisplayScreens.displayHeader();
        DisplayScreens.displayHomeScreen();
        int homeInput = scanner.nextInt();
        scanner.nextLine();
        boolean deliOpen = true;
        while (deliOpen){
            if (homeInput == 1){
                orderMenu();
            }
            if (homeInput == 2){
                deliOpen = false;
            }
        }

    }

    public void orderMenu(){
        boolean ordering = true;
        while (ordering){
           DisplayScreens.displayHeader();
           DisplayScreens.displayOrderScreen();
           int input = scanner.nextInt();
           scanner.nextLine();
           switch (input){
               case 1: method.addSandwich();
               break;
               case 2: method.addDrink();
               break;
               case 3: method.addChips();
               break;
               case 4:
               break;
               case 5: ordering = false;
               break;
           }
        }
    }
}
