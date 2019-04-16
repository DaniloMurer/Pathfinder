package test;

import com.danilojakob.Logik;
import com.danilojakob.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class TestParameterized {

    private int height_;
    private int length_;
    private int expectedResult_;
    private int[][] numbers_;

    public TestParameterized(int height, int length, int expectedResult) {
        super();
        this.height_ = height;
        this.length_ = length;
        this.expectedResult_ = expectedResult;
    }

    @Parameterized.Parameters
    public static List<Object[]> input() {
        return Arrays.asList(new Object[][] {
                {3, 3, 5 }, {4, 4, 7}, {5, 5, 9}, {10, 10, 19}, {13, 12, 24} });
    }

    @Test
    public void selectPaht() {
        Object[] arrays = Main.testCreateField(height_, length_);
        numbers_ = (int[][]) arrays[1];
        assertEquals(expectedResult_, Logik.testSelectPath(numbers_, height_, length_));
    }

}
