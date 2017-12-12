import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ScoreBoardTest {

    @Test
    public void should_update_score_when_goals_happen() {
        ScoreBoard scoreBoard = new ScoreBoard("Team A", "Team B");
        assertThat(scoreBoard.asString(), is("Team A 0 : 0 Team B"));
        assertThat(scoreBoard.react("Team A"), is("Team A 1 : 0 Team B"));
    }
}
