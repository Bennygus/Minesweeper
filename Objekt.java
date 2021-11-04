package com.company;

public class Objekt {

    private String[] X = {"A", "B", "C", "D", "E", "F", "G", "H", "j", "I"};
    private boolean boomb;
    private boolean flagg;


    public Objekt(String [] X,boolean boomb, boolean flagg){
        this.X=X;
        this.boomb=boomb;
        this.flagg=flagg;

        for (  int i = 0;i <= 9; i++) {
            System.out.println(X[i]+"0 "+X[i]+"1 "+X[i]+"2 "+X[i]+"3 "+X[i]+"4 "+X[i]+"5 "+X[i]+"6 "+X[i]+"7 "+X[i]+"8 "+X[i]+"9");
        }
    }
    public String[] getX() {
        return X;
    }


    public void setName(String[]X) {
        this.X = X;
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






