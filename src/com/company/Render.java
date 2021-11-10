package com.company;

import java.util.Scanner;

public class Render {

    private final String letterSeparator = "+--------------------";
    String separator = "=========================";
    private final String[] menuList = {"New","Load","High score"};
    private String[] positionIndexOne = {"0","1","2","3","4","5","6","7","8","9"};
    private String[] positionIndexTwo = {"A","B","C","D","E","F","G","H","I","J"};

    public String[] getPositionIndexOne() {
        return this.positionIndexOne;
    }


    public String[] getPositionIndexTwo() {
        return this.positionIndexTwo;
    }



    public String[] getMenuList() {
        return menuList;
    }




    public String renderFunction(String[] menuList,String message){
             Scanner input = new Scanner(System.in);
        // display part for menu make a for each loop , fill&use the menuList

        System.out.println("Welcome to minesweeper");
        for (String k:menuList){
            System.out.println(k);
        }

             System.out.println(separator);
            System.out.println(message);
            System.out.println(separator);


             System.out.print("> ");

        return input.nextLine().trim().toUpperCase();

         }







}
