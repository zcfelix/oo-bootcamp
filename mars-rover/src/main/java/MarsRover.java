import java.util.List;

public class MarsRover {

    private Position position;
    private Direction direction;

    public MarsRover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public String run(String input) {
        List<Command> commands = CommandParser.parseCommand(input);
        commands.forEach(command -> command.execute(this));
        return asString();
    }

    public void move() {
        position.updateX(direction.getStepOnX());
        position.updateY(direction.getStepOnY());
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    private String asString() {
        return position.getX() + " " + position.getY() + " " + direction;
    }
}
