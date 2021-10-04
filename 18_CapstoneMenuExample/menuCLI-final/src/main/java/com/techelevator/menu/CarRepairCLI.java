package com.techelevator.menu;


import com.techelevator.exceptions.BatteryReplaceException;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CarRepairCLI {

    private Menu menu;
    private Scanner inputScanner; // = new Scanner(System.in); -- initialize here or in
                                  //  constructor

    // create some constants for the main menu
    private final String MAIN_MENU_OPTION_SERVICE = "Service Menu";
    private final String MAIN_MENU_OPTION_PAYMENT = "Payment Menu";
    private final String MAIN_MENU_EXIT = "Exit";

    private final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_SERVICE,
            MAIN_MENU_OPTION_PAYMENT, MAIN_MENU_EXIT};

    //constructor to instantiate the menu object
    public CarRepairCLI(Menu menu){
        this.menu = menu;
        inputScanner = new Scanner(System.in);  // instantiate the Scanner object
    }

    public void run(){
        boolean shouldLoop = true;
        BigDecimal totalCost = new BigDecimal(0.00);
        while (shouldLoop){
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
//            System.out.println(choice);

            if (choice.equals(MAIN_MENU_OPTION_SERVICE)){
                System.out.println(MAIN_MENU_OPTION_SERVICE);
                 totalCost = serviceMenu();

            } else if (choice.equals(MAIN_MENU_OPTION_PAYMENT)){
                System.out.println(MAIN_MENU_OPTION_PAYMENT);
                paymentMenu(totalCost);
            } else {
                System.out.println("Thank you for your patronage!");
                shouldLoop = false;
            }
        }
    }

    public BigDecimal serviceMenu(){
        final String OIL_CHANGE = "Oil Change";
        final String TIRE_ROTATION = "Tire Rotation";
        final String BATTERY_REPLACEMENT = "Battery Replacement";
        final String BRAKE_WORK = "Brake Work";
        final String ALIGNMENT_WORK = "Alignment Adjustment";
        final String RETURN_TO_MAIN_MENU = "Return to Main Menu";

        final String[] SERVICE_MENU_OPTIONS =
                {OIL_CHANGE, TIRE_ROTATION, BATTERY_REPLACEMENT,
                BRAKE_WORK, ALIGNMENT_WORK, RETURN_TO_MAIN_MENU};

        BigDecimal price = new BigDecimal("0.0");
        boolean shouldLoop = true;
         while (shouldLoop){
             String choice = (String) menu.getChoiceFromOptions(SERVICE_MENU_OPTIONS);

             switch(choice){
                 case OIL_CHANGE:
                     System.out.println("Price: $39.99");
                     price = price.add(new BigDecimal(39.99));
                     break;
                 case TIRE_ROTATION:
                     System.out.println("Price: $10.00 per wheel");
                     System.out.print("Enter number of tires to rotate: ");
                     boolean isInt = false;
                     while (!isInt){
                         try {
                             Integer rotate = Integer.parseInt(inputScanner.nextLine());
                             if (rotate < 0 || rotate > 4){
                                 throw new IllegalArgumentException();
                             }
                             price = price.add(new BigDecimal(rotate * 10));
                             isInt = true;
                         } catch (IllegalArgumentException e){
                             System.out.println("Invalid number - please re-enter");
                         }
                     }

                     break;
                 case BATTERY_REPLACEMENT:
                     System.out.println("Battery replacement");
                     try {
                         throw new BatteryReplaceException();
                     } catch (BatteryReplaceException e) {
                         e.printStackTrace();
                     }
                     break;
                 case BRAKE_WORK:
                     break;
                 case ALIGNMENT_WORK:
                     break;
                 case RETURN_TO_MAIN_MENU:
                     shouldLoop = false;
             }
         }
        return price;
    }

    public void paymentMenu(BigDecimal totalCost){
        System.out.println("Your total cost is $" +
                totalCost.setScale(2, RoundingMode.HALF_UP));

    }

    public static void main(String[] args){
        Menu menu = new Menu(System.in, System.out);
        CarRepairCLI cli = new CarRepairCLI(menu);

        cli.run();
    }

}
