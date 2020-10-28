package test.java;

import main.java.lesson1.Task1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TestTask1 {

    @Test(dataProvider = "dp")
    public void min(int a, int b, int c, int expectedMin) {
        int actualMin = Task1.min(a, b, c);
        assertEquals(expectedMin, actualMin, String.format("Expected %d to be min than %d,", expectedMin, actualMin));
    }
    @DataProvider(name = "dp")
    public Object[][] provider() {
        return new Object[][]{
                {3,5,2,2},
                {2,3,5,2},
                {1,2,3,1},
                {-1,0,20,-1}
        } ;
    }
}
