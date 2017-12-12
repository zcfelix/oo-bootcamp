import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReporterTest {
    @Test
    public void should_reporter_say_goals_when_goals_happen() {
        Reporter reporter = new Reporter();
        assertThat(reporter.react("Team A"), is("Team A Goooooal!"));
    }
}
