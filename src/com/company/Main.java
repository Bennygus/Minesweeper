package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	// write your code here
        Scanner input = new Scanner(System.in);


        // Store input from renderMenu in actionInput
        String actionInput =renderMenu();


    }

    private static String renderMenu() {
        Render renderMenu = new Render();
        String message = "CHOOSE YOUR ACTION";

        return renderMenu.renderFunction(renderMenu.getMenuList(),message);
    }


}
