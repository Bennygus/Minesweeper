package com.company.src;

import java.util.ArrayList;
import java.util.Scanner;

public class ActionSweep3 {
     boolean isTrue = false;
     String message = "Game Over";

     public void gameOver(ArrayList<Objekt> objects){
         Render pullFromRender = new Render();

         for(Objekt object:objects){
             if(object.isBomb() ) {
               object.setState("*");
             }


         }
         Render render = new Render();
      String message = " Game Over";















    }
}


