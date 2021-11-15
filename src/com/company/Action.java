package com.company;

import java.util.*;

public class Action {

    private static Object Main;
    private static Object Objekt;


    static void myMethod(String actioninput, ArrayList<Main> Main) {
        Scanner input = new Scanner(System.in);


        String message = "CHOOSE YOUR ACTION";
        if (actioninput.length() == 3) {
            String[] letters = {"  ","A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            for (int i = 0; i < 9; i++) {
            String[] splitstring = actioninput.toUpperCase().split("");

            if (splitstring[0].contains("S") ||splitstring[0].contains("F")){

            }
            if (splitstring[0].equals("S") ||splitstring[0].equals("F")){
                System.out.println("WRONG ACTION KEY");

                if(splitstring[i].contains("")){
                    System.out.println(splitstring[i]);
                    if(letters.equals(splitstring[0])){

                        if (splitstring[i].contains("Flagged")){
                            System.out.println("CAN'T SWEEP because it is flagged");
                        }
                        if(splitstring[1].contains("Not Flagged")){
                            System.out.println("CAN SWEEP because it is not flagged");
                        }
            }




                   }


               }
            }

        }
    }
}
