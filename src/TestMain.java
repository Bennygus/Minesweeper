package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

public class TestMain{
    public static void main(String[] args){
        Scanner inputLoad = new Scanner(System.in);

        String filePath = "";
        File saveFiles = new File(filePath);

        ArrayList<TestObject> testObjectList = new ArrayList<>();
        boolean isTrue = false;
        String message ="CHOOSE YOUR ACTION:";
        boolean isLoad;
        int counter = 0;
        int[] loadOldBombs = new int[10];
        TestRender renderMethod = new TestRender();
        TestObject callTestObjectMethods =new TestObject();
        String txt = ".txt";





        while(true){
            testObjectList.clear();
            isLoad = false;


            String actionInput =  renderMethod.renderFunction(renderMethod.getMenuList(), message);


            //TODO make method for load
            // check out load old and type sa9 and sa8 doesn't sweep to the rigth as it should be from actionInput(boxed in)
            // will make a good debug file! for cascading sweep.
            if (actionInput.trim().equalsIgnoreCase("load")){

                String[] pathnames;

                //better way to make path? where does it origin from the standar path? and make a string instead
                File f = new File("C:\\Users\\gatts\\Documents\\Minesweeper");

                //replace with lambda?
                FilenameFilter filter = new FilenameFilter() {
                    @Override
                    public boolean accept(File f, String name) {
                        return name.endsWith(".txt");
                    }
                };

                System.out.println("Choose a save file");


                pathnames = f.list(filter);
                for (String pathname : pathnames) {

                    System.out.println(pathname.replace(txt,""));
                }

                filePath = inputLoad.nextLine();
                filePath+=txt;
                saveFiles = new File(filePath);

                actionInput = "new";
                isLoad = true;

            }

            if (actionInput.trim().equalsIgnoreCase("new")){

                //TODO maybe do a if statement her of instead just lock out the bombs if user choose load
                // REASON: problem write a new game just to write over with old save files instead. check and fix it!
                callTestObjectMethods.createObjects(testObjectList);
                callTestObjectMethods.randomBomb(testObjectList,isLoad);


                isTrue = true;
                if (isLoad ){


                    loadObjectData(saveFiles);
                    testObjectList = loadObjectData(saveFiles);


                    for (TestObject n: testObjectList){
                        if (n.isBomb()){

                            int bom = testObjectList.indexOf(n);
                            loadOldBombs[counter]=bom;
                            callTestObjectMethods.setContain(loadOldBombs);

                            counter++;
                        }

                    }
                    counter = 0;
                }

            }

            while (isTrue){

                actionInput = renderMethod.renderFunctionTwo(message, testObjectList);

                TestAction sweepAction = new TestAction();

                if (message.equalsIgnoreCase("GAME OVER!")){
                    message = "CHOOSE YOUR ACTION:";
                    break;
                }

                message =sweepAction.search(actionInput, testObjectList, callTestObjectMethods.getContain(),saveFiles);

            }


        }


    }

    public static ArrayList<TestObject> loadObjectData(File saveFiles){

        ArrayList<TestObject> loadList = new ArrayList<>();
        try {

            boolean fileCreated = saveFiles.createNewFile();
            if(!fileCreated){

                Scanner fileReader = new Scanner(saveFiles);
                while (fileReader.hasNextLine()){

                    String[] saveEntry = fileReader.nextLine().split(" ");

                    boolean bomb= Boolean.parseBoolean(saveEntry[2]);
                    boolean flag= Boolean.parseBoolean(saveEntry[3]);
                    boolean nearBomb= Boolean.parseBoolean(saveEntry[4]);


                    TestObject createObject = new TestObject(saveEntry[0],saveEntry[1], bomb,flag,nearBomb);
                    loadList.add(createObject);

                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return loadList;
    }

    public static void writeToFile(File saveFile,ArrayList<TestObject> testObjectList){

        try {

            FileWriter myWriter = new FileWriter(saveFile);
            for (TestObject obj: testObjectList){
                myWriter.write(obj.toString()+ "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }










}
