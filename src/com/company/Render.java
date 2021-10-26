package com.company;

import java.util.Scanner;

public class Render {


    String separator = "=========================";

    Render(){}



    public void renderFunction(String[] menu,String message){
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







}
