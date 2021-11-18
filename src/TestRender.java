package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class TestRender {

    private int counter = 0;
    // private int l = 10;
    // private int b = 0;
    // private int c = 9;
    private final String letterSeparator = "+--------------------";
    private final String separator = "=========================";
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



    //TODO better name
    public String renderFunction(String[] menu,String message){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to minesweeper");
        for (String k:menu){
            System.out.println(k);
        }
        System.out.println(separator);
        System.out.println(message);
        System.out.println(separator);


        System.out.print("> ");

        return input.nextLine().trim().toUpperCase();

    }
    //TODO better name
    public String renderFunctionTwo(String message, ArrayList<TestObject> testObjectList){
        Scanner input = new Scanner(System.in);

        System.out.print("   ");
        for (String k : positionIndexTwo) {

            System.out.print(" "+k);
        }
        System.out.println();
        System.out.println("  "+ letterSeparator);
        for (String m : positionIndexOne) {


            System.out.print(m+" |");

            //TODO make a for each loop that's dynamic
            //TODO do better!
            for (String n : positionIndexTwo) {

                System.out.print(" "+ testObjectList.get(counter).getState());
                counter++;
            }
            //*/
            // funny
            //for (int j = b; j < l; j++) {
//
            //    System.out.print(" "+ boardTestList.get(j).getState());
//
//
//
            //    if (j >=c){
            //        b+=10;
            //        l +=10;
            //        c += 10;
            //        break;
            //    }
//
//
            //}


            System.out.println();
        }
        counter = 0;
        // if (boardTestList.size()==100){
//
        //     l = 10;
        //     b = 0;
        //     c = 9;
        // }
        System.out.println(separator);
        System.out.println(message);
        System.out.println(separator);


        System.out.print(">");


        return input.nextLine().trim();
    }



}
