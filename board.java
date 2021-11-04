package com.company;

import java.util.Scanner;
import java.util.Set;

public class board {
    public static void main(String[] args) {

        String[] letters = {"  ","A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};



        int [] number = {0,0,1,2,3,4,5,6,7,8,9};

            for (int i = 0; i <= 10; i++) {

                for (int j = 0; j <= 10; j++) {

                    if (i == 0) {

                        System.out.print(letters[j]);

                    } else if (j == 0) {
                        System.out.print(number[i]+"|");
                    } else {
                        System.out.print("X");

                    }
                        System.out.print(" ");
                }

                System.out.println();


        }
        System.out.println("=======================");
        Scanner scanner=new Scanner(System.in);
        System.out.println("CHOOSE YOUR ACTION:");
        String Action= scanner.nextLine();
        System.out.println("=======================");
    }


}
