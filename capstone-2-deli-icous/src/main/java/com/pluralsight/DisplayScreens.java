package com.pluralsight;

import com.pluralsight.interfaces.Item;

public class DisplayScreens {

    public static void displayHeader(){
        System.out.println("""
                 _____________
               (               )
              (_________________)
                DELI-CIOUS DELI
              -------------------
             (                   )
              (_________________)
             """);
    }
    public static void displayOrderScreen(){
        System.out.println("""
                WOULD YOU LIKE TO:
                
                (1) ADD A SANDWICH
                (2) ADD A DRINK
                (3) ADD CHIPS
                (4) CHECKOUT
                (0) CANCEL ORDER AND GO HOME
                """);
    }

    public static void displayHomeScreen(){
        System.out.println( """
                (1) NEW ORDER
                (2) EXIT
                """);
    }

    public static String chooseSandwich(){
        return  """
                SELECT YOUR SANDWICH
                (1) BLT
                (2) PHILLY CHEESE STEAK
                (3) BUILD YOUR OWN
                """;
    }

    public static String displaySelectBreadType(){
        return  """
                PLEASE SELECT THE TYPE OF BREAD THAT YOU WOULD LIKE:
                
                (0) WHITE
                (1) WHEAT
                (2) RYE
                (3) WRAP
                """;
    }


    public static String displaySelectBreadSize(){
        return  """
                PLEASE SELECT YOUR BREAD SIZE:
                
                (0) SMALL  (4 INCH)
                (1) MEDIUM (8 INCH)
                (2) LARGE  (12 INCH)
                """;
    }

    public static String displayMeats(){
        return  """
                WHAT MEAT WOULD YOU LIKE?
                
                (0) STEAK
                (1) HAM
                (2) SALAMI
                (3) ROAST BEEF
                (4) CHICKEN
                (5) BACON
                (6) NO MEAT
                (7) IM DONE ADDING MEAT
                """;
    }
    public static String askForExtraMeat(){
        return "WOULD YOU LIKE EXTRA MEAT? (Enter yes or no)";
    }

    public static String displayCheese(){
        return """
                WHAT CHEESE WOULD YOU LIKE?
                (0) AMERICAN
                (1) PROVOLONE
                (2) CHEDDAR
                (3) SWISS
                (4) NO CHEESE
                """;
    }

    public static String askForExtraCheese(){
        return "WOULD YOU LIKE EXTRA CHEESE? (Enter yes or no)";
    }

    public static String displaySauces(){
        return """
                SELECT YOUR SAUCES:
                (0) MAYO
                (1) MUSTARD
                (2) KETCHUP
                (3) RANCH
                (4) THOUSAND ISLAND
                (5) VINAIGRETTE
                (6) NO SAUCE
                (7) IM DONE WITH SAUCES
                """;
    }

    public static String moreSauce(){
        return  "WOULD YOU LIKE TO ADD MORE SAUCE? (Enter yes or no)";
    }

    public static String whatToppings(){
        return """
                WHAT TOPPINGS WOULD YOU LIKE?
                
                (0) LETTUCE
                (1) PEPPERS
                (2) ONIONS
                (3) TOMATOES
                (4) JALEPENOS
                (5) CUCUMBERS
                (6) PICKLES
                (7) GUACAMOLE
                (8) MUSHROOMS
                (9) IM DONE WITH TOPPINGS
                """;
    }

    public static String moreToppings(){
        return  "WOULD YOU LIKE TO ADD MORE TOPPINGS? (Enter yes or no)";
    }

    public static String toastedOrNo(){
        return  "WOULD YOU LIKE IT TOASTED (YES OR NO)?";
    }

    public static String anotherSandwich(){
        return  "WOULD YOU LIKE TO ADD ANOTHER SANDWICH (YES OR NO)?";
    }

    public static String typeOfChips(){
        return """
                WHAT TYPE OF CHIPS WOULD YOU LIKE?
                (0) DORITOS
                (1) LAYS
                (2) SOUR CREAM AND ONION
                (3) NO MORE CHIPS
                """;
    }

    public static String moreChips(){
        return  "WOULD YOU LIKE TO ADD MORE CHIPS? (Enter yes or no)";
    }

    public static String whatDrinkSize(){
        return """
                WHAT SIZE DRINK WOULD YOU LIKE?
                
                (0) SMALL
                (1) MEDIUM
                (2) LARGE
                (3) NEVER MIND I DON'T WANT A DRINK
                """;
    }

    public static String drinkType(){
        return """
                WHAT KIND OF DRINK WOULD YOU LIKE?
                (0) WATER
                (1) COKE
                (2) SPRITE
                (3) SWEET TEA
                (4) UN-SWEET TEA
                (5) MOUNTAIN DEW
                (6) SIGNATURE DRINK
                """;
    }

    public static String moreDrink(){
         return  "WOULD YOU LIKE ANOTHER DRINK? (Enter yes or no)";
    }

    public static String displayCheckout(){
        return """
                 ARE YOU SURE THAT YOU WOULD LIKE TO CHECK OUT?
                 (0) TO CONFIRM
                 (1) CANCEL ORDER
                """;
    }

    public static void whatComesOnPhilly(){
        System.out.println("""
Philly Cheese Steak
o 8" white bread
o Steak
o American Cheese
o Peppers
o Mayo
o Toasted
                """);
    }

    public static void whatComesOnBLT(){
        System.out.println("""
               BLT
               o 8" white bread
               o Bacon
               o Cheddar
               o Lettuce
               o Tomato
               o Ranch
               o Toasted
               """);
    }

    public void orderSummary(){
        System.out.println("""
                ===============================
                         ORDER SUMMARY
                ===============================""");
        }


}

