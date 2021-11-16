package com.company.src;

import java.util.*;

public class Action {



    public String myMethod(String actioninput, ArrayList<Objekt> objectList) {



        String message = "CHOOSE YOUR ACTION";
        if (actioninput.length() == 3) {
            String[] splitstring = actioninput.toUpperCase().split("");

            if (splitstring[0].contains("S") || splitstring[0].contains("F")) {
                for (int j = 0; j < 100; j++)
                    if (objectList.get(j).getName().equals(splitstring[1] + splitstring[2])) {
                        if (splitstring[0].contains("S")) {
                            if (objectList.get(j).isFlagg()) {
                                message = "CAN SWEEP because it is flagged";
                            }
                            if (!objectList.get(j).isFlagg()) {

                            }
                        }
                    }

            } else if (!splitstring[0].contains("S") || !splitstring[0].contains("F")) {

                message = "WRONG ACTION KEY";


            }


        }

        return message;
    }
}



