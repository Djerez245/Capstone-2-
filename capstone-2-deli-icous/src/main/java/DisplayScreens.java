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
                (4) ADD A SIDE
                (5) CHECKOUT
                (0) CANCEL ORDER
                """);
    }

    public static void displayHomeScreen(){
        System.out.println("""
                (1) NEW ORDER
                (2) EXIT
                """);
    }
    public static void displaySelectBreadType(){
        System.out.println("""
                PLEASE SELECT THE TYPE OF BREAD THAT YOU WOULD LIKE:
                
                (0) WHITE
                (1) WHEAT
                (2) RYE
                (3) WRAP
                """);
    }


    public static void displaySelectBreadSize(){
        System.out.println("""
                PLEASE SELECT YOUR BREAD SIZE:
                
                (0) SMALL  (4 INCH)
                (1) MEDIUM (8 INCH)
                (2) LARGE  (12 INCH)
                """);
    }

    public static void displayMeats(){
        System.out.println("""
                WHAT MEAT WOULD YOU LIKE?
                
                (0) STEAK
                (1) HAM
                (2) SALAMI
                (3) ROAST BEEF
                (4) CHICKEN
                (5) BACON
                (6) NO MEAT
                """);
    }
    public static void askForExtraMeat(){
        System.out.println("WOULD YOU LIKE EXTRA MEAT?");
    }

    public static void displayCheese(){
        System.out.println("""
                WHAT CHEESE WOULD YOU LIKE?
                (0) AMERICAN
                (1) PROVOLONE
                (2) CHEDDAR
                (3) SWISS
                (4) NO CHEESE
                """);
    }

    public static void askForExtraCheese(){
        System.out.println("WOULD YOU LIKE EXTRA CHEESE?");
    }

    public static void displaySauces(){
        System.out.println("""
                SELECT YOUR SAUCES:
                (0) MAYO
                (1) MUSTARD
                (2) KETCHUP
                (3) RANCH
                (4) THOUSAND ISLAND
                (5) VINAIGRETTE
                (6) NO SAUCE
                (7) IM DONE WITH SAUCES
                """);
    }

    public static void whatToppings(){
        System.out.println("""
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
                """);
    }

    public static void toastedOrNo(){
        System.out.println("WOULD YOU LIKE IT TOASTED (YES OR NO)?");
    }

    public static void AnotherSandwich(){
        System.out.println("WOULD YOU LIKE TO ADD ANOTHER SANDWICH (YES OR NO)?");
    }

    public static void typeOfChips(){
        System.out.println("""
                WHAT TYPE OF CHIPS WOULD YOU LIKE?
                (0) DORITOS
                (1) LAYS
                (2) SOUR CREAM AND ONION
                (3) NO MORE CHIPS
                """);
    }

    public static void moreChips(){
        System.out.println("WOULD YOU LIKE TO ADD MORE CHIPS?");
    }

    public static void WhatDrinkSize(){
        System.out.println("""
                WHAT SIZE DRINK WOULD YOU LIKE?
                
                (0) SMALL
                (1) MEDIUM
                (2) LARGE
                (3) NEVER MIND I DON'T WANT A DRINK
                """);
    }

    public static void drinkType(){
        System.out.println("""
                WHAT KIND OF DRINK WOULD YOU LIKE?
                (0) WATER
                (1) COKE
                (2) SPRITE
                (3) SWEET TEA
                (4) UN-SWEET TEA
                (5) MOUNTAIN DEW
                (6) SIGNATURE DRINK
                """);
    }

    public static void displayCheckout(){
        System.out.println("""
                 ARE YOU SURE THAT YOU WOULD LIKE TO CHECK OUT CHECK-OUT?
                 (0) TO CONFIRM
                 (1) IM NOT DONE YET
                """);
    }

}

