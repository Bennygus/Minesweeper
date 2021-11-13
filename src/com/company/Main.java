package com.company;



import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        boolean isTrue = false;
        String message = "CHOOSE YOUR ACTION";
        Render pullFromRender = new Render();
        ArrayList<Objekt> objectList = new ArrayList<>();



        while(true){

            // Store input from renderMenu in actionInput
            String actionInput =renderMenu();

            if (actionInput.equalsIgnoreCase("new")){
                 for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        // Give every object a name ex: A + 0 (both strings) = A0 ,next will be B0 , j = letters and i numbers
                         Objekt createObject = new Objekt((pullFromRender.positionIndexTwo[j] + pullFromRender.positionIndexOne[i]));
                         //Object created added to list
                         objectList.add(createObject);

                    }
                }

                 Objekt createBomb = new Objekt();
                // Make random objects set to contain a bomb by calling randomBomb method
                 createBomb.randomBomb(objectList);


                isTrue = true;
            }
            //New game
            while (isTrue){

                //Users input need to be stored(actionInput) and put in the method from the action class
                actionInput = pullFromRender.renderFunctionTwo(message, objectList);



                //Make a method call from action class and store it to message







            }


        }


    }













    private static String renderMenu() {
        Render renderMenu = new Render();
        String message = "CHOOSE YOUR ACTION";

        return renderMenu.renderFunction(renderMenu.getMenuList(),message);
    }


}
