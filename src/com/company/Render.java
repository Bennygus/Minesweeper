package com.company;

import java.util.Scanner;

public class Render {
    String[] menuList = {};

    String separator = "=========================";





    public String renderFunction(String[] menu,String message){
             Scanner input = new Scanner(System.in);
        // display part for menu make a for each loop , fill&use the menuList

        System.out.println("display");
        System.out.println("display");
        System.out.println("display");

             System.out.println(separator);
            System.out.println(message);
            System.out.println(separator);


             System.out.print("> ");

        return input.nextLine().trim();

         }







}
