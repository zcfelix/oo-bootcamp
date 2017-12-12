public class Fan {
    private String supportedTeam;

    public Fan(String supportedTeam) {
        this.supportedTeam = supportedTeam;
    }

    public String react(String team) {
        return team.equals(supportedTeam) ? "Hooray!" : "Boooo!";
    }
}
