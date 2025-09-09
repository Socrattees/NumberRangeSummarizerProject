package numberrangesummarizer;

import java.util.*;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImp implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().isEmpty()) { //returns an empty List if input is empty
            return Collections.emptyList();
        }
        try {
            return Arrays.stream(input.split(",")) //splits the string input and turns result into new Stream
                    .map(String::trim) //maps the Stream<String>, trimming each element in case of whitespaces
                    .map(Integer::parseInt) //maps the Stream, converting each element into an integer
                    .distinct() //removes any duplicates as they don't matter by the end and reduces code complexity
                    .sorted() //sorts the elements in the Stream
                    .collect(Collectors.toList()); //converts result into a new List
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input contains elements besides integers");
        }
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input.isEmpty()) return ""; //returns an empty string if list is empty

        List<Integer> numbers = new ArrayList<>(input); //conversion allows math to be used on input
        ArrayList<String> strings = new ArrayList<>(); //variable will store elements for result
        int start = numbers.get(0); //variable going to be used for lower-bound range if range exists
        int end = start; //variable to be used for upper-bound range and for non-range elements

        for (int i = 1; i < numbers.size(); i++) { //start at index 1 as "end" initially assigned index 0
            int current = numbers.get(i); //variable to make code easier to follow

            //in the case of a sequential pattern, "end" takes the "current" value and loop continues
            if (current == end + 1) {
                end = current;
            } else { //sequential pattern no longer found or nonexistent, adding element to "strings" and continue loop
                strings.add(formatRange(start, end));
                end = current;
                start = end;
            }
        }

        /* as the last "numbers" index is not added to "strings" during loop, this adds the last element,
           which either is a single value or a range. This part is done the way it is to reduce
           the complexity of the loop
        */
        strings.add(formatRange(start, end));


        return String.join(",", strings); //returns string that contains "strings" elements, separated by ","
    }

    private String formatRange(int start, int end) { //formats inputs into range format for summarizeCollection()
        return start == end ? String.valueOf(end) : start + "-" + end; //returns single value or range
    }
}
