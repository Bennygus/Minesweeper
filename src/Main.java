import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        for(int row =0; row < 10; row++) {
            for(int column = 0; column < 10; column++) {
                System.out.print("X ");
            }
            System.out.println();
        }
        Scanner input = new Scanner(System.in);
        System.out.print("");
        int row = input.nextInt();
        int column = 10;
        boolean boardGame = row > column;

        if (boardGame){
            System.out.print(column);
        }
        else {
            System.out.print("X");
        }

    }

}
