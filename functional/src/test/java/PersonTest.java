import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class PersonTest {


    private List<Person> persons;
    private Function<Person, String> byName;
    private Function<Person, Integer> byAge;

    @Before
    public void setUp() {
        persons = asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35)
        );

        byName = Person::getName;
        byAge = Person::getAge;
    }

    @Test
    public void should_sort_person_by_age() {
        System.out.println("Compare persons by age:");
        persons.stream().sorted(comparing(byAge)).forEach(System.out::println);
    }

    @Test
    public void should_sort_person_by_name() {
        System.out.println("Compare persons by name:");
        persons.stream().sorted(comparing(byName)).forEach(System.out::println);
    }

    @Test
    public void should_sort_person_by_age_and_name() {
        System.out.println("Compare persons by age and name:");
        persons.stream().sorted(comparing(byAge).thenComparing(byName)).forEach(System.out::println);
    }

    @Test
    public void should_group_person_by_age() {
        Map<Integer, List<Person>> groupingByAge = persons.stream().collect(groupingBy(byAge));
        System.out.println(groupingByAge);
    }

    @Test
    public void should_group_person_by_age_with_only_names() {
        Map<Integer, List<String>> groupingByAgeWithOnlyNames = persons
                .stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
        System.out.println(groupingByAgeWithOnlyNames);
    }

    @Test
    public void should_group_person_by_first_letter_and_find_max_age_in_each_group() {
        Map<Character, Optional<Person>> groups = persons
                .stream()
                .collect(groupingBy(person -> person.getName().charAt(0), reducing(BinaryOperator.maxBy(comparing(byAge)))));
        System.out.println(groups);
    }
}
