import numberrangesummarizer.NumberRangeSummarizer;
import numberrangesummarizer.NumberRangeSummarizerImp;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImp();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collected = summarizer.collect(input);
        String summarizeCollection = summarizer.summarizeCollection(collected);

        System.out.println(summarizeCollection);
    }
}