import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Mommifier {
    private static final List<String> VOWELS = asList("a", "e", "i", "o", "u");

    public String mommify(final String input) {
        if (null == input) {
            return null;
        } else if (Arrays.stream(input.split("")).filter(VOWELS::contains).count() > input.length() / 3.0d) {
            return input.replaceAll("[aeiou]+", "mommy");
        } else {
            return input;
        }
    }
}
