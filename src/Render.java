package com.company.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Render {

    private final String letterSeparator = "+--------------------";
    private final String separator = "=======================";
   // private final String[] menuList = {"New","Load","High score"};
    //hamdi
   private String[] menulist = {"New", "Load","Highscore" };


    final String[] positionIndexOne = {"0","1","2","3","4","5","6","7","8","9"};
    final String[] positionIndexTwo = {"A","B","C","D","E","F","G","H","I","J"};
    private int counter =0;







    public String renderFunction(String[] menuList,String message){
             Scanner input = new Scanner(System.in);

             //hamdi
        System.out.println("Welcome to Minesweeper");
        for (String M: menulist)
            System.out.println(M);// write your code here



             System.out.println(separator);
            System.out.println(message);
            System.out.println(separator);


             System.out.print("> ");

        return input.nextLine().trim().toUpperCase();

         }
    public String renderFunctionTwo(String message, ArrayList<Objekt>objectList){
        Scanner input = new Scanner(System.in);
        String[] letters = {"  ","A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int [] number = {0,0,1,2,3,4,5,6,7,8,9};
        for (int row = 0; row <= 10; row++) {

            for (int column = 0; column <= 10; column++) {

                if (row == 1 && column ==0){
                    System.out.println(" "+ letterSeparator);
                }

                if (row == 0) {

                    System.out.print(letters[column]);

                }


                else if (column == 0) {
                    System.out.print(number[row]+"|");
                }

                //  Scanner input = new Scanner(System.in);
                //  System.out.print("");
                //  int row = input.nextInt();
                //  int column = 10;
                //  boolean boardGame = row > column;

                //  if (boardGame){
                //      System.out.print(column);
                //  }

                else{

                    System.out.print(objectList.get(counter).getState());

                    counter++;

                }



                System.out.print(" ");
            }

            System.out.println();


        }

        counter = 0;


        System.out.print("");

        System.out.println(separator);
        System.out.println(message);
        System.out.println(separator);


        System.out.print(">");


        return input.nextLine().trim();
    }

    public String[] getPositionIndexOne() {
        return this.positionIndexOne;
    }

    public String[] getPositionIndexTwo() {
        return this.positionIndexTwo;
    }

    public String[] getMenulist() {
        return menulist;
    }

    public void setMenulist(String[] menulist) {
        this.menulist = menulist;
    }
}
