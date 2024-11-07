import java.util.Scanner;

public class UserInterface {

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
               case 1:
           }
        }
    }
}
