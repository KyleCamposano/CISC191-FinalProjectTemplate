package edu.sdccd.cisc191.template;

import java.util.Scanner;

public class DigitsGame extends RandomizeArrays {   // able to call methods from RandomizeArrays class.
    public DigitsGame() {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter any key to continue.");
        userInput.nextLine();
        System.out.println("I'm a combination of two single digits.\n" +
                "I may only be between none to nine.\n" +
                "Yet I promise I can break your spirit.\n" +
                "If you neglect to read between the line.\n\n" +
                "Press [ENTER] to continue.");

        userInput.nextLine();



        System.out.println();

        /*
          calls random2D method from RandomizeArrays class,
          declares new int 2-dimensional array, and
          initializes the size of the array. This size is
          the same size as the x bound of the random.nextInt().
         */

        boolean isCorrect = false;
        while (!isCorrect) {
            int firstNumber = random2D(new int[9][9]);
            int secondNumber = random2D(new int[9][9]);

            //uncomment to print the random numbers
            // to test if user input matches.
            //System.out.println(firstNumber);
            //System.out.println(secondNumber);

            System.out.print("What's my first half?\n");
            int firstHalf = userInput.nextInt();
            System.out.print("What's my other half?\n");
            int secondHalf = userInput.nextInt();


            /*  Alternative for loop:
                for (int row = 0; row < numbers.length; row++) {
                    for (int column = 0; column < numbers[row].length; column++) {
                        if (numbers[row][0] == firstHalf && numbers[row][1] == secondHalf) isCorrect = true;
             */

            if (firstNumber == firstHalf && secondNumber == secondHalf) {

                isCorrect = true;
            }

            if (isCorrect) {
                System.out.print("That's correct!\n\n------------------------------------\n");
                System.out.println("You have completed all of the games.\n" +
                        "Thank you for playing!");
            } else {
                System.out.print("--Wrong combination! Try again.--\n\n");
            }
        }
    }
}
