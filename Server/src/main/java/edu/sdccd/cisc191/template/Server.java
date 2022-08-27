package edu.sdccd.cisc191.template;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * This is two consecutive games. The first game is to guess a random color,
 * followed by the second game to guess a pair of two single digits. The
 * second game is only prompted if the user finishes the first game.
 */

public class Server {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int guessLimit = 0;

        /*
          this riddle is modified from the original in
          https://riddles-for-kids.org/rainbow-riddles/
         */

        System.out.println("I’m a color in the sky\n" +
                "I'm part of a curve mentioned in the first book of the Bible but I’m not a snake\n" +
                "I sit next to many other colors\n" +
                "We are all mentioned in a Wizard Of Oz song but I’m not a Yellow Brick Road\n" +
                "I can be found near a leprechaun but I’m not a pot of gold\n\n" +
                "Press [ENTER] to continue");

        userInput.nextLine();

        System.out.println("What color am I?");

        String userGuess = userInput.nextLine().toLowerCase();

        /*
          correctColor contains randomly selected element from the colors array.
          This allows different correct answers everytime the user is prompted.
         */

        String[] colors = {"Red", "Orange", "Yellow", "Green", "Indigo", "Blue", "Violet"};
        Random random = new Random();
        int randomColorIndex = random.nextInt(colors.length);
        String correctColor = colors[randomColorIndex].toLowerCase();

        /*
          This while loop continues to prompt the user until the guessLimit is reached,
          and ends when guessLimit is reached (or the user correctly guesses!)
         */

        while (!userGuess.equals(correctColor) && guessLimit < 2) {
            System.out.println("Sorry, wrong color!");
            guessLimit += 1;
            userGuess = userInput.nextLine().toLowerCase();
            if (!userGuess.equals(correctColor) && guessLimit == 2) {
                System.out.println("Out of guesses!");
            }
        }
        if (userGuess.equals(correctColor)) {
            System.out.println("Your guess is correct! \n\n-------------------------------------");
            System.out.println("Would you like to play another game?");
            userGuess = userInput.nextLine().toLowerCase();

            /*
              This is a new prompt for another game upon successfully completing the
              first game. User can either continue or terminate the program here.
             */

            while (!(userGuess.equals("yes") || userGuess.equals("no"))) {
                System.out.println("Invalid input. Please answer yes or no");
                userGuess = userInput.nextLine().toLowerCase();
            }

            if (userGuess.equals("no")) {
                System.out.println("Thank you for playing the game!");
            } else {
                System.out.println("Enter any key to continue.");
                userInput.nextLine();
                System.out.println("I'm a combination of two single digits.\n" +
                        "I may only be between none to nine.\n" +
                        "Yet I promise I can break your spirit.\n" +
                        "If you neglect to read between the line.\n\n" +
                        "Press [ENTER] to continue.");

                userInput.nextLine();

                /*
                   The 2D array is declared and initialized. It's fed random numbers
                   and two pairs of correct answers are generated. This is done by
                   using nested for loops with an if statement to break out. The user
                   must guess any of the pairs correctly.
                 */

                int[][] numbers = new int[2][2];
                random = new Random();

                System.out.println();

                for (int i = 0; i < numbers.length; i++) {
                    for (int j = 0; j < numbers[i].length; j++) {
                        numbers[i][j] = random.nextInt(9);
                    }
                }
                /*
                  System.out.println(Arrays.deepToString(numbers));
                  Prints out the two pairs of correct answers.
                  Uncomment to test if userInput matches numbers array.
                 */

                boolean isCorrect = false;
                while (!isCorrect) {
                    System.out.print("What's my first half?\n");
                    int firstHalf = userInput.nextInt();

                    System.out.print("What's my other half?\n");
                    int secondHalf = userInput.nextInt();

                    /*  Alternative for loop:
                        for (int row = 0; row < numbers.length; row++) {
                            for (int column = 0; column < numbers[row].length; column++) {
                                if (numbers[row][0] == firstHalf && numbers[row][1] == secondHalf) isCorrect = true;
                     */

                    for (int[] number : numbers) {
                        for (int column = 0; column < number.length; column++) {
                            if (number[0] == firstHalf && number[1] == secondHalf) {
                                isCorrect = true;
                                break;
                            }
                        }
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
    }
}
