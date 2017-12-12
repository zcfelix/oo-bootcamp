import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FanTest {

    private final Fan teamAFan = new Fan("Team A");

    @Test
    public void should_fan_hooray_when_supported_team_goals() {
        assertThat(teamAFan.react("Team A"), is("Hooray!"));
    }

    @Test
    public void should_fan_boooo_when_other_team_goals() {
        assertThat(teamAFan.react("Team B"), is("Boooo!"));
    }
}
