package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Objekt {

    private String state = "X";
    private String Name;
    private boolean bomb = false;
    private boolean flagg = false;
    private int newBomb;
    private int[] contain = new int[10];


    Objekt(){}

    public Objekt(String Name){

        this.Name=Name;


    }


    public void randomBomb(ArrayList<Objekt> objectList){

        Random rand = new Random();



        for(int i=0;i<10;i++)
        {
            newBomb = rand.nextInt(100);
            contain[i]= newBomb;

            for (int j=0;j<i;j++)
            {

                if (contain[i] == contain[j])
                {
                    i--;
                    break;
                }
            }
        }

        for (int i=0;i<contain.length;i++) {


            objectList.get(contain[i]).setBomb(true);

                  }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return Name;
    }


    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isFlagg() {
        return flagg;
    }

    public void setFlagg(boolean flagg) {
        this.flagg = flagg;
    }

    public int[] getContain() {
        return contain;
    }




}








