package com.company;

public class Objekt {

    private String X;
    private String Name;
    private boolean boomb;
    private boolean flagg;
    private int newBomb;
    private int[] contain = new int[10];


    public Objekt(String X,String Name,boolean boomb, boolean flagg){
        this.X=X;
        this.boomb=boomb;
        this.flagg=flagg;
        this.Name=Name;


    }

    /*
    public void randomBomb(ArrayList<BoardTest> boardTestList){
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

            // containTwo.add(contain[i]) ;
            // System.out.println(containTwo.get(i) + "ss");





            boardTestList.get(contain[i]).setBomb(true);
            System.out.println(contain[i]); //list index of bombs
        }
    }
    */

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








