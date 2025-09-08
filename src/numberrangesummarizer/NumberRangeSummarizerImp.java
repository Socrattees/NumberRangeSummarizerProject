package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImp implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                return Collections.emptyList();
            }
            return Arrays.stream(input.split(",")) //splits the string input and turns result into Stream<String>
                    .map(String::trim) //maps the Stream, trimming each element in case of whitespaces
                    .map(Integer::parseInt) //maps the Stream, converting each element into an integer
                    .sorted() //sorts the elements in the Stream
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input contains elements besides integers");
        }
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        return "";
    }
}
