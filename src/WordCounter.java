import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordCounter {
    private Stream<String> inputStream;

    public WordCounter(Stream<String> inputStream) {
        this.inputStream = inputStream;
    }

    public void printWordCount() {
        Map<String, Long> wordCount = inputStream
                .map(String::toLowerCase)
                .map(line -> line.split("[\\p{Punct}\\s]+"))
                .flatMap(Arrays::stream)
                .collect(groupingBy(identity(), counting()));

        wordCount.remove("");

        wordCount.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted(Comparator.comparing((Map.Entry<String, Long> entry) -> entry.getValue()).reversed())
                .forEach(System.out::println);
    }
}
