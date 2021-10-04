package com.techelevator.menu;

import com.techelevator.view.Menu;

public class UseMenuEmpty {

    private static final String MAIN_MENU_OPTION_ONE = "Menu Option 1";
    private static final String MAIN_MENU_OPTION_TWO = "Menu Option 2";
    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_ONE, MAIN_MENU_OPTION_TWO};

    private Menu menu;

    public UseMenuEmpty(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_ONE)) {
                // do something here
            } else if (choice.equals(MAIN_MENU_OPTION_TWO)) {
                // do something else here
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        UseMenuEmpty cli = new UseMenuEmpty(menu);
        cli.run();
    }
}