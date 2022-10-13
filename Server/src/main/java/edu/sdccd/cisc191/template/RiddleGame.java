package edu.sdccd.cisc191.template;

import java.util.Scanner;


/**
 * This game is consecutive to the ColorGame and requires
 * its completion. It shows a riddle dependent on the
 * user's input (number 1-5). RiddleGame is not prompted
 * until the successful attempt of ColorGame.
 */


public class RiddleGame {
    int a = 0;
    static String b = "";

    /*
        acts as a container for the riddles and their answers
        using switch. More riddles can be added in the future
        with no modification needed in the RiddleGame() method.
    */
    public static int RiddleCollection(int a) {

        switch(a) {
            case 1: // source: https://goodriddlesnow.com/riddles/view/2494
                System.out.println("I can fly like a bird not in the sky which can\n" +
                        "always swim and always dry. I say goodbye at night and morning\n" +
                        "hi. I'm part of you, what am I? I follow and lead as you pass.\n" +
                        "Dress yourself in black my darkness lasts. I flee the light, but\n" +
                        "without the sun your view of me would be gone.\n");
                b = "shadow";
                break;

            case 2: // source: https://parade.com/947956/parade/riddles/
                System.out.println("I’m tall when I’m young,\n" +
                        "and I’m short when I’m old. What am I?\n");
                b = "candle";
                break;

            case 3: // source: https://parade.com/947956/parade/riddles/
                System.out.println(" What is always in front of you but can’t be seen?\n");
                b = "future";
                break;

            case 4: // source: https://parade.com/947956/parade/riddles/
                System.out.println("What goes up but never comes down?\n");
                b = "age";
                break;

            case 5: // source: https://parade.com/947956/parade/riddles/
                System.out. println("What can you keep after giving to someone?\n");
                b = "word";
                break;
        }
        return a;
    }

    /*
        This stores the user's int input as userInput
        and compares it to the switch cases (for the
        riddle and its answer).
     */
    public RiddleGame() {

        //  allows to only prompt RiddleGame if ColorGame is completed.
        boolean finishGame = new ColorGame().finishGame;

        if (finishGame) {

            Scanner userInput = new Scanner(System.in);

            System.out.println("Welcome to the secret game!");

            //  if adding more riddles, update "numbers 1 through 5" to the correct max.
            System.out.println("Please select numbers 1 through 5 to select a riddle.");

            int startingRiddle = RiddleCollection(userInput.nextInt());

            while (startingRiddle > 5 || startingRiddle < 1) {
                System.out.println("Please enter a number between 1 to 5.");
                startingRiddle = RiddleCollection(userInput.nextInt());
            }

            if (userInput.equals(startingRiddle)) {
                System.out.println(RiddleCollection(a));

            }

            System.out.println("What am I?");

            //  uncomment to show correct riddle answer
            //  for unit testing purposes.
            //  System.out.println(b);

            userInput.nextLine();

            boolean isCorrect = false;

            while (!isCorrect) {

                String userGuess = userInput.nextLine().toLowerCase();

                if (userGuess.equals(b)) isCorrect = true;

                if (isCorrect) {
                    System.out.println("That's correct!\n");
                } else {
                    System.out.println("Nope. Try again!");
                }
            }
        }
    }
}
