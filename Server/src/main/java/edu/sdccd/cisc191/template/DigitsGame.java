package edu.sdccd.cisc191.template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Prompts user to guess randomly selected single
 * digits in the 2-dimensional array. User has no
 * limit to guess the pair of numbers. This is a
 * standalone game, only with Game interface
 * implementation.
 */

//  inherits methods from RandomizeArrays class
//  implements abstract methods from Game interface
public class DigitsGame extends RandomizeArrays implements Game, Achievable {

    //  compiles the override methods
    public DigitsGame() {
        GameSetup();
        GameStart();
        getNumberOfTries();
        GameEnd();
    }

    @Override
    public void GameSetup() {
        System.out.println("\nWelcome to the third game of this series!\n");
    }
    int guessLimit = 0;

    @Override
    public void GameStart() {
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
            int firstNumber = randomize(new int[9][9]);
            int secondNumber = randomize(new int[9][9]);

            //  uncomment to print the random numbers
            //  to test if user input matches.
            System.out.println(firstNumber);
            System.out.println(secondNumber);

            System.out.print("What's my first half?\n");
            int firstHalf = userInput.nextInt();
            System.out.print("What's my other half?\n");
            int secondHalf = userInput.nextInt();


            /*
              Alternative for loop:
              for (int row = 0; row < numbers.length; row++) {
                  for (int column = 0; column < numbers[row].length; column++) {
                      if (numbers[row][0] == firstHalf && numbers[row][1] == secondHalf) isCorrect = true;
             */

            if (firstNumber == firstHalf && secondNumber == secondHalf) {
                isCorrect = true;
            }

            if (isCorrect) {
                System.out.print("That's correct!\n\n------------------------------------\n\n");
            } else {
                System.out.print("--Wrong combination! Try again.--\n\n");
            }

            guessLimit++;
        }
    }

    @Override
    public void GameEnd() {
        System.out.println("You have completed all games!"
        + "\nThank you for playing!\n");
    }

    /*
      This appends to the empty results.txt. The number of tries
      will only be written into results.txt if the user attempts
      to play the game. No attempt tries will show if the user
      answers "no" to playing another game.
    */
    @Override
    public void getNumberOfTries() {
        File file = new File("results.txt");

        /*
          This ensures that this game is modular. If results.txt
          does not exist, then the program will still continue.
        */
        if(file.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt", true));
                writer.write("\n[SECOND GAME]");
                writer.write("\nYou have tried " + guessLimit + " time(s) to get the correct answer.\n");
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
