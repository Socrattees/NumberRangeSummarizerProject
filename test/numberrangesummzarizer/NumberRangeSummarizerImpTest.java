package numberrangesummzarizer;

import numberrangesummarizer.NumberRangeSummarizer;
import numberrangesummarizer.NumberRangeSummarizerImp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class NumberRangeSummarizerImpTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImp();

    /* Test the collect method */

    //test case where valid input is provided
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

    //test case where empty string input is provided
    @Test
    void testCollectWithEmptyString() {
        Collection<Integer> expected = Collections.emptyList();
        Collection<Integer> result = summarizer.collect("");
        assertEquals(expected, result);
    }

    //test case where invalid input is provided and that the appropriate error message is provided in response
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

    //test case where valid input is provided
    @Test
    void testSummarizeCollectionValidInput() {
        String expected = "2, 5, 13-15, 23";
        Collection<Integer> collected = summarizer.collect("15, 5, 2, 13, 14, 23");
        String result = summarizer.summarizeCollection(collected);

        assertEquals(expected, result);
    }

    //test case where there is single value
    @Test
    void testSummarizeCollectionSingleInput() {
        String expected = "2";
        Collection<Integer> collected = summarizer.collect("2");
        String result = summarizer.summarizeCollection(collected);

        assertEquals(expected, result);
    }

    //test case where all values are sequential
    @Test
    void testSummarizeCollectionSequentialInput() {
        String expected = "20-26";
        Collection<Integer> collected = summarizer.collect("20, 21, 22, 23, 24, 25, 26");
        String result = summarizer.summarizeCollection(collected);

        assertEquals(expected, result);
    }

    //test case where there are no sequential numbers
    @Test
    void testSummarizeCollectionNoSequentialInput() {
        String expected = "1, 3, 5, 7";
        Collection<Integer> collected = summarizer.collect("1, 3, 5, 7");
        String result = summarizer.summarizeCollection(collected);

        assertEquals(expected, result);
    }
}
