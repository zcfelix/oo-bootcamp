import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class WordPickerTest {
    private final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

    private List<String> words;

    @Before
    public void setUp() {
        words = asList("Nancy", "Ninja", "Letter", "Basket", "Banana");
    }

    @Test
    public void should_pick_words_starts_with_n() {
        words.stream().filter(startsWithLetter.apply("N")).forEach(System.out::println);
    }

    @Test
    public void should_pick_words_starts_with_b() {
        words.stream().filter(startsWithLetter.apply("B")).forEach(System.out::println);
    }

    @Test
    public void should_filter_words_and_collect_to_new_list() {
        List<String> ret = words
                .stream()
                .filter(startsWithLetter.apply("B"))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(ret);
    }
}
