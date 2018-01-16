import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class WordPickerTest {
    private final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

    private final Function<String, Predicate<String>> endsWithLetter = letter -> name -> name.endsWith(letter);

    private final Function<String, Function<String, Predicate<String>>> startsOrEndsWithLetter = position -> position.equals("start") ? startsWithLetter : endsWithLetter;

    private List<String> names;
    private List<String> names2;

    @Before
    public void setUp() {
        names = asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        names2 = asList("Kobe", "Nina", "Jack", "Tommy", "Black");
    }

    @Test
    public void should_pick_works_starts_with_b() {
        final Predicate<String> startWithB = name -> name.startsWith("B");

        names.stream().filter(startWithB).forEach(System.out::println);
        names2.stream().filter(startWithB).forEach(System.out::println);
    }

    @Test
    public void should_return_immutable_list() {
        final Person felix = new Person("felix", 26);
        final Person kitty = new Person("kitty", 25);
        final List<Person> list = Collections.unmodifiableList(asList(felix, kitty));
        list.get(0).setName("Tom");
        System.out.println(list);
    }

    @Test
    public void should_pick_words_starts_with_s() {
        final Predicate<String> startWithS = x -> x.startsWith("S");
        names.stream().filter(startWithS).forEach(System.out::println);
    }

    @Test
    public void should_pick_words_starts_with_t() {
        Function<String, Predicate<String>> checkIfStartWithLetter = letter -> name -> name.startsWith(letter);
        names2.stream().filter(checkIfStartWithLetter.apply("T")).forEach(System.out::println);
    }

    @Test
    public void should_pick_words_starts_with_n() {
        names.stream().filter(startsWithLetter.apply("N")).forEach(System.out::println);
    }

    @Test
    public void should_pick_words_starts_with_b() {
        names.stream().filter(startsWithLetter.apply("B")).forEach(System.out::println);
    }

    @Test
    public void should_filter_words_and_collect_to_new_list() {
        List<String> ret = names
                .stream()
                .filter(startsWithLetter.apply("B"))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(ret);
    }

    @Test
    public void should_filter_words_starts_with_b_and_ends_with_a() {
        List<String> ret = names
                .stream()
//                .filter(startsWithLetter.apply("B").and(endsWithLetter.apply("n")))
                .filter(startsOrEndsWithLetter.apply("start").apply("B").and(startsOrEndsWithLetter.apply("end").apply("a")))
                .collect(toList());
        System.out.println(ret);
    }

}
