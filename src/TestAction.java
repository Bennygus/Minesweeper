package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.TestMain.writeToFile;

public class TestAction {

    private int startUpperColumn;
    private int startPointMiddleColumn;
    private int startLowerColumn;
    private int startRow =0;
    private int endRow =3;
    private int endPointColumn = 3;
    private int bombCounter = 0;
    private int typedObject;
    private ArrayList<Integer> sweepList = new ArrayList<>();
    private int sweepCounter = 0;
    private int bombPosition;
    //better name
    private final String txt=".txt";
    private boolean isNearBombTrue = false;



    public String search(String actionInput, ArrayList<TestObject> testObjectList, int[] contain, File saveFiles){
        String message = "CHOOSE YOUR ACTION:";

        // TODO should the mark around bomb be done in action?
        // marking every object around bomb
        markAroundBomb(testObjectList, contain);

        // triggers if 3 letters long reason: sweeping or flagging
        if (actionInput.length()==3) {
            String[] splitString = actionInput.trim().toUpperCase().split("");

            if (splitString[0].toUpperCase().contains("S") || splitString[0].toUpperCase().contains("F")) {


                // TODO break loop when done maybe? do a for-each loop instead?
                for (int u=0;u<testObjectList.size();u++){

                    if (testObjectList.get(u).getName().equals(splitString[1] + splitString[2])){

                        //sweeping condition
                        if (splitString[0].toUpperCase().contains("S")) {

                            //--------------Flag condition---------------
                            if (testObjectList.get(u).isFlag()){
                                message="CAN'T SWEEP " + testObjectList.get(u).getName() + "\n" + "REASON: FLAGGED";

                            }

                            if (!testObjectList.get(u).isFlag()) {
                                //--------------end of flag------------------
                                //-------------Bomb/loose condition----------

                                if (testObjectList.get(u).isBomb()) {
                                    message = "GAME OVER!" ;


                                    for (int n : contain){
                                        if (testObjectList.get(n).isFlag()){
                                            testObjectList.get(n).setState("!");
                                        }
                                        if (testObjectList.get(n).isBomb()&&!testObjectList.get(n).isFlag()){
                                            testObjectList.get(n).setState("*");

                                        }
                                    }

                                }
                                //---------End of loose condition--------
                                //TODO make a wrong type if-statement inside ex: sk1  or s12
                                else if (!testObjectList.get(u).isBomb()) {
                                    startPointMiddleColumn = testObjectList.indexOf(testObjectList.get(u));
                                    sweepList.add(startPointMiddleColumn);


                                    while (true) {

                                        //TODO sweep done! sweep all not done
                                        //TODO need it to be separated with adding object and check for bombs?

                                        // reset the starting point
                                        typedObject = startPointMiddleColumn;

                                        // if object is near a bomb
                                        if (testObjectList.get(typedObject).isNearBomb()) {
                                            isNearBombTrue = true;

                                        }
                                        // private?
                                        String[] splitStringTwo = testObjectList.get(typedObject).getName().toUpperCase().split("");

                                        //TODO need this if done right?
                                        startRow = 0;
                                        endRow = 3;
                                        endPointColumn = 3;
                                        startUpperColumn = (startPointMiddleColumn - 11);
                                        startLowerColumn = (startPointMiddleColumn + 9);

                                        //---------------------Restriction Settings-----------------------

                                        restriction(testObjectList, splitStringTwo);


                                        //---------------------End of Restriction Settings----------------

                                        //-------------------Add more objects-------------------
                                        if (!isNearBombTrue) {
                                            // Cascading sweep adding more objects to sweep
                                            addingMoreObjectsToSweep(testObjectList);
                                        }
                                        //-------------------end of adding-------------------

                                        // set the startPoint to the right place
                                        startRow =0;
                                        endRow =3;
                                        endPointColumn = 3;
                                        startPointMiddleColumn = typedObject;
                                        startUpperColumn = (startPointMiddleColumn - 11);
                                        startLowerColumn = (startPointMiddleColumn + 9);

                                        //--------------Restriction settings again---------------------
                                        restriction(testObjectList,splitStringTwo);
                                        //----------------end of settings------------------------------

                                        //--------------Check if any contains a bomb-------------------

                                        checkIfTypedObjectIsNearBombs(testObjectList);
                                        //--------------Check ended------------------------------------


                                        // old code prob don't need it
                                        //startPointMiddleColumn = typedObject;

                                        testObjectList.get(typedObject).setState(Integer.toString(bombCounter));

                                        //TODO if statement needed anymore?
                                        if (!(sweepList.size() ==0)) {
                                            startPointMiddleColumn = testObjectList.indexOf(testObjectList.get(sweepList.get(sweepCounter)));
                                        }

                                        sweepCounter++;
                                        bombCounter =0;
                                        isNearBombTrue = false;
                                        if (sweepCounter==sweepList.size()|| sweepList.size()==0){
                                            break;
                                        }


                                    }

                                }


                            }
                        }
                        //----------check/set Flag------------
                        else if (splitString[0].toUpperCase().contains("F")){

                            if (testObjectList.get(u).isFlag()) {
                                message = "ALREADY FLAGGED:";
                            }

                            if (!testObjectList.get(u).isFlag()) {
                                testObjectList.get(u).setFlag(true);
                                testObjectList.get(u).setState("F");
                            }

                        }
                        //-------------end flag---------------

                    }
                }

            }
            // end of containing s or f

            else if (!splitString[0].toUpperCase().contains("S") || !splitString[0].toUpperCase().contains("F") ) {

                message = "WRONG ACTION KEY:\nDOESN'T EXIST!";
            }

        }

        if (actionInput.equalsIgnoreCase("Exit")) {

            System.exit(0);

        }
        if(actionInput.equalsIgnoreCase("Save")){
            Scanner input = new Scanner(System.in);
            System.out.println("Type in the name for the save file");
            String filePath = input.nextLine();
            //TODO better name
            filePath+=txt;

            saveFiles = new File(filePath);
            message ="CHOOSE YOUR ACTION:\nGAME SAVED.";


            writeToFile(saveFiles, testObjectList);

        }

        if (actionInput.length() != 3&&!actionInput.equalsIgnoreCase("save")){
            message = "ERROR!\nTYPE IN RIGHT ACTION:\nS/F{squareName}";

        }

        return  message ;
    }
    //-------------------End-----------------------
    //-------------------Methods-------------------

    private void checkIfTypedObjectIsNearBombs(ArrayList<TestObject> testObjectList) {
        for (int i = startRow; i < endRow; i++) {

            for (int j = (startPointMiddleColumn -1); j < ((startPointMiddleColumn -1 ) + endPointColumn); j++) {
                if (i == 0) {


                    if (testObjectList.get(startUpperColumn).isBomb()) {
                        bombCounter++;

                    }
                    startUpperColumn++;
                }
                if (i == 1) {

                    if (testObjectList.get(j).isBomb()) {
                        bombCounter++;

                    }
                }
                if (i == 2) {


                    if (testObjectList.get(startLowerColumn).isBomb()) {
                        bombCounter++;
                    }
                    startLowerColumn++;
                }

            }

        }
    }

    private void addingMoreObjectsToSweep(ArrayList<TestObject> testObjectList) {
        for (int i = startRow; i < endRow; i++) {

            for (int j = (startPointMiddleColumn - 1); j < ((startPointMiddleColumn - 1) + endPointColumn); j++) {

                if (i == 0) {

                    if (!testObjectList.get(startUpperColumn).isBomb() && !sweepList.contains(startUpperColumn)) {
                        sweepList.add(testObjectList.indexOf(testObjectList.get(startUpperColumn)));
                    }

                    startUpperColumn++;
                }
                if (i == 1) {

                }
                if (!testObjectList.get(j).isBomb() && !sweepList.contains(j)) {
                    sweepList.add(testObjectList.indexOf(testObjectList.get(j)));
                                   }
                if (i == 2) {

                    if (!testObjectList.get(startLowerColumn).isBomb() && !sweepList.contains(startLowerColumn)) {
                        sweepList.add(testObjectList.indexOf(testObjectList.get(startLowerColumn)));
                    }
                    startLowerColumn++;

                }

            }

        }
    }


    private void markAroundBomb(ArrayList<TestObject> testObjectList, int[] contain) {
        for (int b = 0;b<10;b++){

            //bad try with load files
            // if (isLoad){
            //     bombPosition= loadOldBombs[b];
//
//
            // }
            // if (!isLoad) {
            //     //every bomb
            //     bombPosition = contain[b];
            // }

            //every bomb
            bombPosition = contain[b];
            // bad name
            String[] nearBombSplit = testObjectList.get(bombPosition).getName().toUpperCase().split("");


            checkIsNearBomb(testObjectList,nearBombSplit,bombPosition);
        }
    }


    private void checkIsNearBomb(ArrayList<TestObject> testObjectList, String[] nearBomb, int bombPosition){

        //TODO need this? prob do because restriction
        startPointMiddleColumn = bombPosition;
        startRow =0;
        endRow =3;
        endPointColumn = 3;
        startUpperColumn = (startPointMiddleColumn - 11);
        startLowerColumn = (startPointMiddleColumn + 9);
        restriction(testObjectList,nearBomb);


        for (int i = startRow; i < endRow; i++) {

            for (int j = (startPointMiddleColumn -1); j < ((startPointMiddleColumn -1 ) + endPointColumn); j++) {
                if (i == 0) {

                    if (!testObjectList.get(startUpperColumn).isBomb()) {
                        testObjectList.get(startUpperColumn).setNearBomb(true);
                    }



                    startUpperColumn++;
                }
                if (i == 1) {

                    if (!testObjectList.get(j).isBomb()) {
                        testObjectList.get(j).setNearBomb(true);
                    }
                }
                if (i == 2) {

                    if (!testObjectList.get(startLowerColumn).isBomb()) {
                        testObjectList.get(startLowerColumn).setNearBomb(true);
                    }
                    startLowerColumn++;
                }

            }

        }


    }
    private void restriction(ArrayList<TestObject> testObjectList, String[] splitStringTwo) {
        //TODO check if it's really needed with all settings

        if (testObjectList.get(startPointMiddleColumn).getName().equalsIgnoreCase("A0")) {


            startPointMiddleColumn += 1;
            startLowerColumn += 1;
            startRow = 1;
            endPointColumn -= 1;

        }
        if (testObjectList.get(startPointMiddleColumn).getName().equalsIgnoreCase("A9")) {
            startPointMiddleColumn += 1;
            endRow -= 1;
            endPointColumn -= 1;
            startUpperColumn += 1;
        }

        if (testObjectList.get(startPointMiddleColumn).getName().contains("A") && !splitStringTwo[1].equalsIgnoreCase("0") && testObjectList.get(startPointMiddleColumn).getName().contains("A") && !splitStringTwo[1].equalsIgnoreCase("9")) {
            startPointMiddleColumn += 1;
            endPointColumn -= 1;
            startUpperColumn += 1;
            startLowerColumn += 1;
        }

        if (testObjectList.get(startPointMiddleColumn).getName().equalsIgnoreCase("J0")) {

            startRow = 1;
            endPointColumn -= 1;

        }
        if (testObjectList.get(startPointMiddleColumn).getName().equalsIgnoreCase("J9")) {

            endPointColumn -= 1;
            endRow -= 1;

        }

        if (testObjectList.get(startPointMiddleColumn).getName().contains("J") && !splitStringTwo[1].equalsIgnoreCase("0") && testObjectList.get(startPointMiddleColumn).getName().contains("J") && !splitStringTwo[1].equalsIgnoreCase("9")) {
            endPointColumn -= 1;
        }

        if (testObjectList.get(startPointMiddleColumn).getName().contains("0") && !splitStringTwo[0].equalsIgnoreCase("A") && testObjectList.get(startPointMiddleColumn).getName().contains("0") && !splitStringTwo[0].equalsIgnoreCase("J")) {
            startRow = 1;
//
        }

        if (testObjectList.get(startPointMiddleColumn).getName().contains("9") && !splitStringTwo[0].equalsIgnoreCase("A") && testObjectList.get(startPointMiddleColumn).getName().contains("9") && !splitStringTwo[0].equalsIgnoreCase("J")) {
            endRow -= 1;
        }

    }


}

