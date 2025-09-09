package numberrangesummzarizer;

import numberrangesummarizer.NumberRangeSummarizer;
import numberrangesummarizer.NumberRangeSummarizerImp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class NumberRangeSummarizerImpTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImp();

    /* Test the collect method */

    //test that valid input works
    @Test
    void testCollectWithValidInput() {
        Collection<Integer> expected = Arrays.asList(2, 6, 28);
        Collection<Integer> result = summarizer.collect("6, 28, 2");
        assertEquals(expected, result);
    }

    //test that white space is removed from the element(s) of result
    @Test
    void testCollectWithWhitespace() {
        Collection<Integer> expected = Arrays.asList(13, 22, 30);
        Collection<Integer> result = summarizer.collect("13, 30 , 22");
        assertEquals(expected, result);
    }

    //test that code is able to handle empty string input
    @Test
    void testCollectWithEmptyString() {
        Collection<Integer> expected = Collections.emptyList();
        Collection<Integer> result = summarizer.collect("");
        assertEquals(expected, result);
    }

    //test that the code throws an error when an invalid input is provided
    @Test
    void testCollectWithInvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            summarizer.collect("21, boo, 42");
        });
        assertEquals("Input contains elements besides integers", exception.getMessage());
    }


    /* Test the summarizeCollection method */

        //test that code is able to handle empty List input
        @Test
        void testSummarizeCollectionEmptyList() {
            String expected = "";
            Collection<Integer> collected = summarizer.collect("");
            String result = summarizer.summarizeCollection(collected);

            assertEquals(expected, result);
        }
    }
