package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ServerTest {

    private static String[] colorsOne, colorsTwo;

    private static int[][] numbers;

    @BeforeAll
    public static void setUp() {
        colorsOne = new String[]{"Red"};
        colorsTwo = new String[]{"Yellow", "Blue"};
        numbers = new int[][]{{},{}};
    }

    /*
      unnecessary to create unit tests for void methods as they return
      nothing, it has no possible side effects. Only two methods
      utilized by both games are RandomizeArrays.randomize()
     */

    @Test //  tests for randomizing Strings in RandomizeArrays class.
    public void randomizeString() {
        assertEquals("red", RandomizeArrays.randomize(colorsOne).toLowerCase());
        assertTrue(Arrays.asList(colorsOne).contains("Red"));
        assertTrue(Arrays.asList(colorsTwo).contains("Blue"));
    }

    @Test //  tests for randomizing ints in RandomizeArrays class.
    public void randomizeInt() {
        assertTrue(RandomizeArrays.randomize(numbers) < 10);
        assertFalse(RandomizeArrays.randomize(numbers) > 10);
    }

    @Test //  tests for selecting riddles in RiddleGame class.
    public void correctRiddle() {
        assertEquals(1, RiddleGame.RiddleCollection(1));
        assertEquals(2, RiddleGame.RiddleCollection(2));
        assertEquals(3, RiddleGame.RiddleCollection(3));
        assertEquals(4, RiddleGame.RiddleCollection(4));
        assertEquals(5, RiddleGame.RiddleCollection(5));
    }
    @Test //  tests for createFile method in HandlingFile class.
    public void createFile() {
        assertEquals("newFile.txt", HandlingFile.createFile("newFile.txt"));
        assertEquals("oldFile.pdf", HandlingFile.createFile("oldFile.pdf"));
    }

    @Test //  tests for deleteFile method in HandlingFile class.
    public void deleteFile() {
        assertEquals("newFile.txt", HandlingFile.deleteFile("newFile.txt"));
        assertEquals("oldFile.pdf", HandlingFile.deleteFile("oldFile.pdf"));
    }
}
