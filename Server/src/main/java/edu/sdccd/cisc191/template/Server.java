package edu.sdccd.cisc191.template;

//import java.net.*;
//import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**

 */
public class Server {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); //declaring and initializing Scanner class
        System.out.println("What color am I thinking?");
        String userGuess = userInput.nextLine().toLowerCase(); //storing any user input as lowercase
        //System.out.println(userGuess);
        int guessLimit = 0;

        String[] colors = {"Red", "Orange", "Yellow", "Green", "Indigo", "Blue", "Violet"};
        Random random = new Random(); //declaring and initializing Random class
        int randomColorIndex = random.nextInt(colors.length); //stores the randomly selected index of the array
        String trueColor = colors[randomColorIndex].toLowerCase(); //stores the color of the randomly selected index

        //System.out.println(trueColor);
        //This is to manually print out trueColor test whether array and if statements are working together.

        //this while loop continues to prompt the user until the guessLimit is reached, and ends when
        //guessLimit is reached (or the user correctly guesses!).
        while (!userGuess.equals(trueColor) && guessLimit < 2) {
            System.out.println("Sorry, wrong color!");
            guessLimit += 1;
            userGuess = userInput.nextLine().toLowerCase();
            if (!userGuess.equals(trueColor) && guessLimit == 2) {
                System.out.println("Out of guesses!");

            }
        }
        if (userGuess.equals(trueColor)) {
            System.out.println("Your guess is correct!");
        }

    }
}





