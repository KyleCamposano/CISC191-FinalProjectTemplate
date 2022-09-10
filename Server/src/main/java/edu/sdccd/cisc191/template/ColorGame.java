package edu.sdccd.cisc191.template;

import java.util.Scanner;

public class ColorGame extends RandomizeArrays {    // able to call methods from RandomizeArrays class.
    public ColorGame(){

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
          random1d2d class, random1D method with parameters of an array.
          correctColor contains randomly selected element from the colors array.
          This allows different correct answers everytime the user is prompted.
         */

        String correctColor = random1D(new String[]{"Red", "Orange", "Yellow", "Green", "Indigo", "Blue", "Violet"}).toLowerCase();

        /*
          This while loop continues to prompt the user until the guessLimit is reached,
          and ends when guessLimit is reached (or the user correctly guesses!)
         */

        while (!userGuess.equals(correctColor) && guessLimit < 2) {
            System.out.println("Sorry, wrong color!");
            guessLimit += 1;
            userGuess = userInput.nextLine().toLowerCase();
            if (!userGuess.equals(correctColor) && guessLimit == 2) {
                System.out.println("\n\n-------------------------------------\n" +
                        "Out of guesses!");
            }
        }
        if (userGuess.equals(correctColor)) {
            System.out.println("Your guess is correct! \n\n-------------------------------------");
        }
    }
}