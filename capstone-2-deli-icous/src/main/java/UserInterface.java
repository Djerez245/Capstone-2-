import java.util.Scanner;

public class UserInterface {

    UserInterfaceMethods method;

    DisplayScreens display;
    Scanner scanner = new Scanner(System.in);

    public void deliMenus(){
        boolean deliOpen = true;
        while (deliOpen){
           DisplayScreens.displayHeader();
           DisplayScreens.displayHomeScreen();
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
               case 5: deliOpen = false;
               break;
           }
        }
    }
}
