package numberrangesummzarizer;

import numberrangesummarizer.NumberRangeSummarizer;
import numberrangesummarizer.NumberRangeSummarizerImp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizerImpTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImp();

    /* Test the collect method */

    //test that valid input works
    @Test
    void testCollectWithValidInput() {
        List<Integer> expected = Arrays.asList(2, 6, 28);
        Collection<Integer> result = summarizer.collect("6, 28, 2");
        assertEquals(expected, result);
    }

    //test that white space is removed from the element(s) of result
    @Test
    void testCollectWithWhitespace() {
        List<Integer> expected = Arrays.asList(13, 22, 30);
        Collection<Integer> result = summarizer.collect("13, 30 , 22");
        assertEquals(expected, result);
    }

    //test that code is able to handle empty string
    @Test
    void testCollectionWithEmptyString() {
        List<Integer> expected = Collections.emptyList();
        Collection<Integer> result = summarizer.collect("");
        assertEquals(expected, result);
    }
}
