package edu.sdccd.cisc191.template;

import java.util.Scanner;

/**
 * This is two consecutive games. The first game is to guess a random color,
 * followed by the second game to guess a pair of two single digits. The
 * second game is only prompted if the user finishes the first game.
 */

public class Server {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //  creates a new empty file in the directory
        HandlingFile.createFile();

        //  calls ColorGame() method from ColorGame class with RiddleGame class.
        new RiddleGame();

        //  user is prompted the DigitsGame after completion of Color Game.
        System.out.println("Would you like to try another game?");
        String userGuess = userInput.nextLine().toLowerCase();

        while (!(userGuess.equals("yes") || userGuess.equals("no"))) {
            System.out.println("Invalid input. Please answer yes or no");
            userGuess = userInput.nextLine().toLowerCase();
        }

        //  "yes" option calls the DigitsGame() method from DigitsGame class.
        if (userGuess.equals("yes")){
            new DigitsGame();
        }

        //  the results.txt has been appended in ColorGame and DigitsGame classes
        System.out.println("\nWould you like to view your total attempts?");
        userGuess = userInput.nextLine().toLowerCase();

        if (userGuess.equals("yes")) {
            HandlingFile.readFile(); //reads results.txt
            System.out.println("\n-------------------------------------\n" +
                    "Terminating...\n" +
                    "Thank you for checking out this program!");
        } else {
            System.out.println("\n-------------------------------------\n" +
                    "Terminating...\n" +
                    "Thank you for checking out this program!");
        }

        //calls deleteFile() method to delete output.txt in the directory
        HandlingFile.deleteFile();
    }
}
