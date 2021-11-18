package com.company;

import java.util.ArrayList;

import java.util.Random;

public class
TestObject extends TestRender {


    private String name;
    private String state = "X";
    private boolean isBomb = false;
    private boolean isFlag = false;
    private  boolean isNearBomb = false;
    //TODO prob needs it's own class
    private  int nBomb;
    private int[] contain = new int[10];



    TestObject() {

    }

    public void setContain(int[] contain) {
        this.contain = contain;
    }

    public TestObject(String name, String state, boolean isBomb, boolean isFlag, boolean isNearBomb) {
        this.name = name;
        this.state = state;
        this.isBomb = isBomb;
        this.isFlag = isFlag;
        this.isNearBomb = isNearBomb;
    }

    TestObject(String name){
        this.name = name;
    }

    //TODO could/should i make the list in here instead? to store the objects
    public void createObjects(ArrayList<TestObject> testObjectList){

        for (String n: getPositionIndexOne()){
            for (String m: getPositionIndexTwo()){
                TestObject createObject = new TestObject((m + n));
                testObjectList.add(createObject);


            }

        }


    }

    //TODO make it's own class for randomBomb?
    public void randomBomb(ArrayList<TestObject> testObjectList, Boolean isLoad){
        Random rand = new Random();



        for(int i=0;i<10;i++)
        {
            nBomb = rand.nextInt(100);
            contain[i]= nBomb;

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

           // if load don't set bombs to the objects
            if (!isLoad){
                testObjectList.get(contain[i]).setBomb(true);
              //  System.out.println(contain[i]); //list index of bombs
            }




        }
    }

    // how the save files store its info
    // Format.
    @Override
    public String toString(){
        return  this.getName() + " " +
                this.getState() + " " +
                this.isBomb + " " +
                this.isFlag + " " +
                this.isNearBomb ;
    }

    public int[] getContain() {
        return contain;
    }

    public boolean isNearBomb() {
        return isNearBomb;
    }

    public void setNearBomb(boolean nearBomb) {
        isNearBomb = nearBomb;
    }
    public String getName() {
        return this.name;
    }



    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isBomb() {
        return this.isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isFlag() {
        return this.isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }


}

