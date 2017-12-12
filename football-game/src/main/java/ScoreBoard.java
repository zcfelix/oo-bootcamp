public class ScoreBoard {
    private String teamA;
    private String teamB;

    private int teamAScore;
    private int teamBScore;

    public ScoreBoard(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamAScore = 0;
        this.teamBScore = 0;
    }

    public String react(String team) {
        updateBoard(team);
        return asString();
    }

    public String asString() {
        return String.format("%s %d : %d %s", teamA, teamAScore, teamBScore, teamB);
    }

    private void updateBoard(String team) {
        if (team.equals(teamA)) {
            teamAScore++;
        }
        if (team.equals(teamB)) {
            teamBScore++;
        }
    }
}
