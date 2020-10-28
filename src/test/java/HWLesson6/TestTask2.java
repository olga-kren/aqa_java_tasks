package test.java.HWLesson6;

import main.java.lesson1.Task2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTask2 {
    String actualResult = Task2.getNames();
    String[] strArr = actualResult.split("\n");

    @Test
    public void getNamesTest() {
        int actualLinesAmount = strArr.length;
        int expectedLinesAmount = 5;
        assertEquals(actualLinesAmount, expectedLinesAmount, String.format("Expected lines amount to be %d, but actual was %d", expectedLinesAmount, actualLinesAmount));

    }
    @Test
    public void namesInLineTest(){
        for (String el : strArr) {
            String[] namesArr = el.split(" ");
            int actualNamesInLine = namesArr.length;
            int expectedNamesInLine = 10;
            assertEquals(actualNamesInLine, expectedNamesInLine, String.format("Expected name in line to be %d, but actual was %d", actualNamesInLine, expectedNamesInLine));
        }

    }
}
