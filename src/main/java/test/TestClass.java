package test;

import com.danilojakob.Logik;
import com.danilojakob.Main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestClass {

    private static int[][] numbers;

    @Before
    public void createField() {
        Object[] arrays = Main.testCreateField(3, 3);
        numbers = (int[][]) arrays[1];
        System.out.println("Field created");
    }

    @Test
    public void selectPaht() {
        int moves = Logik.testSelectPath(numbers, 3, 3);
        assertEquals(5, moves);
        System.out.println("Test passed");
    }

    @After
    public void clearField() {
        numbers = null;
        System.out.println("Cleared the array");
    }

}
