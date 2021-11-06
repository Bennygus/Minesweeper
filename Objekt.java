package com.company;

public class Objekt {

    private String X;
    private String Name;
    private boolean boomb;
    private boolean flagg;


    public Objekt(String X,String Name,boolean boomb, boolean flagg){
        this.X=X;
        this.boomb=boomb;
        this.flagg=flagg;
        this.Name=Name;

        for (  int i = 0;i <= 9; i++) {

        }
    }
    public String getX() {
        return X;
    }


    public void setX(String X) {
        this.X = X;
    }

    public String getName() {
        return Name;
    }


    public void setName(String Name) {
        this.Name = Name;
    }
    public boolean getboomb() {
        return boomb;
    }


    public void setBoomb(boolean boomb) {
        this.boomb = boomb;
    }
    public boolean getflag() {
        return flagg;
    }


    public void setFlagg(boolean flagg) {
        this.flagg = flagg;
    }
}








