package test.java.HWLesson6;

import org.testng.annotations.Test;

import static main.java.lesson1.Task5.reverse;
import static org.testng.Assert.*;

public class TestTask5 {
    String reverseResult = reverse("Hello world!!!");

    @Test
    public void testReverse1 (){
        String actualResult = reverseResult;
        String expectedResult = "!!!dlrow olleH";
        boolean isEquals = expectedResult.equals(actualResult);
        assertTrue(isEquals, "Actual result is the same as expected.");
    }
    @Test
    public void testReverseNegative(){
        String actualResult = reverseResult;
        String expectedResult = "Hello world!!!";
        assertNotEquals(actualResult, expectedResult, "Actual result is not the same as expected.");

    }


}
