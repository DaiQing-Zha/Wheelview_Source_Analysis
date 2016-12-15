package lvbu.wang.wheelview_source_analysis;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test(){

        int index = 8;
        int currentItem = 10;
        int temp = 12;
        int result = Math.min(index,currentItem) - Math.max(index,currentItem);
        System.out.println(temp + result);
        System.out.print(temp - Math.abs(index - currentItem));
    }
}