package edu.sdccd.cisc191.template;

import java.util.Random;

public class RandomizeArrays{

    /*
        method requires declaration of size and elements of
        the array to return random String value in the array.
    */
    public static String random1D(String[] a) {
        Random random = new Random();
        int randomIndex = random.nextInt(a.length);
        return String.valueOf(a[randomIndex]);
    }

    /*
        method requires declaration of size and elements of
        the 2-dimensional array to return random int value
        in the array.
    */
    public static int random2D(int[][] a) {
        Random random = new Random();
        int correct = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = random.nextInt(9);
                correct = a[i][j];
            }
        }
        return correct;
    }
}
