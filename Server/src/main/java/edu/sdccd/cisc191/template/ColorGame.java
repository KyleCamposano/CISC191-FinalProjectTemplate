package edu.sdccd.cisc191.template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Prompts user to guess a randomly selected color
 * in the array. User only has 3 tries to guess
 * until it terminates. This is a standalone game,
 * only with Game interface implementation.
 */

// inherits methods from RandomizeArrays class
// implements abstract methods from Game interface
public class ColorGame extends RandomizeArrays implements Game, Achievable {
    boolean finishGame = false;

    //  compiles the override methods
    public ColorGame(){
        GameSetup();
        GameStart();
        getNumberOfTries();
        GameEnd();
    }

    @Override
    public void GameSetup() {
        System.out.println("Welcome to the first game of this series!\n\n");
    }

    int guessLimit = 1;

    @Override
    public void GameStart() {

        Scanner userInput = new Scanner(System.in);

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
          RandomizeArrays class, random1D method with parameters of an array.
          correctColor contains randomly selected element from the colors array.
          This allows different correct answers everytime the user is prompted.
         */

        String correctColor = randomize(new String[]{"Red", "Orange", "Yellow", "Green", "Indigo", "Blue", "Violet"}).toLowerCase();

        /*
          This while loop continues to prompt the user until the guessLimit is reached,
          and ends when guessLimit is reached (or the user correctly guesses!)
         */

        while (!userGuess.equals(correctColor) && guessLimit < 3) {
            System.out.println("Sorry, wrong color!");
            guessLimit += 1;
            userGuess = userInput.nextLine().toLowerCase();

            if (!userGuess.equals(correctColor) && guessLimit == 3) {
                System.out.println("Out of guesses! \n\n-------------------------------------");
            }
        }
        if (userGuess.equals(correctColor)) {
            System.out.println("Your guess is correct! \n\n-------------------------------------");
            finishGame = true;
        }
    }

    @Override
    public void GameEnd(){}

    //  This appends the empty results.txt
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
                writer.write("\n[FIRST GAME]");
                writer.write("\nYou have tried " + guessLimit + " time(s) to get the correct answer.");
                writer.write("\nThe limit of guess is 3!\n");
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}