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

        //calls ColorGame() method from ColorGame class.
        new ColorGame();


        //user is prompted the DigitsGame after completion of Color Game.
        System.out.println("Would you like to continue to another game?");
        String userGuess = userInput.nextLine().toLowerCase();


        while (!(userGuess.equals("yes") || userGuess.equals("no"))) {
            System.out.println("Invalid input. Please answer yes or no");
            userGuess = userInput.nextLine().toLowerCase();
        }

        if (userGuess.equals("no")) {
            System.out.println("\n-------------------------------------\n" +
                    "Terminating...\n" +
                    "Thank you for checking out this program!");
        }
        //"yes" option calls the DigitsGame() method from DigitsGame class.
        if (userGuess.equals("yes")){
            new DigitsGame();
        }
    }
}
