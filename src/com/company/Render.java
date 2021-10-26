package com.company;

import java.util.Scanner;

public class Render {


    String ka= "+-----------";
    String sa= "|";
    String separator = "=========================";
    String[] menuList = {"New","Load","High score"};
    String[] positionIndexOne = {"0","1","2","3","4","5","6","7","8","9"};
    String[] positionIndexTwo = {"A","B","C","D","E","F","G","H","I","J"};
    String[] positionIndexThree = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19"};

    Render(){}



    public void renderFunction(){
        Scanner input = new Scanner(System.in);
        for (String k:menuList){
            System.out.println(k);
        }
        System.out.println(separator);
        System.out.println();
        System.out.println(separator);


        System.out.print(">");
         input.nextLine();

    }
    public void renderFunctionTwo(String[] menu,String message){
        Scanner input = new Scanner(System.in);
        for (String k:menu){
            System.out.println(k);
        }
        System.out.println(separator);
        System.out.println(message);
        System.out.println(separator);


        System.out.print("> ");
        input.nextLine();

    }
    public void renderFunctionThree(){
        Scanner input = new Scanner(System.in);

        System.out.println(separator);
        System.out.println();
        System.out.println(separator);


        System.out.print("> ");
        input.nextLine();

    }



    void dis(){
        System.out.println("sasa");
    }






}
