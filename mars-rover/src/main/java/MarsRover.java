import java.util.List;

import static java.util.Arrays.asList;

public class MarsRover {
    private static final List<String> VALID_COMMANDS = asList("L", "R", "M");

    private Position position;
    private String direction;

    public MarsRover(Position position, String direction) {
        this.position = position;
        this.direction = direction;
    }

    public String run(String input) {
        String[] commandArray = input.split("(?!^)");
        for (String command : commandArray) {
            if (!VALID_COMMANDS.contains(command)) {
                throw new IllegalArgumentException("Invalid command sequence: " + input);
            }
        }
        for (String command : commandArray) {
            switch (command) {
                case "M":
                    move();
                    break;
                case "R":
                    turnRight();
                    break;
                case "L":
                    turnLeft();
                    break;
            }
        }
        return asString();
    }

    private void move() {
        switch (direction) {
            case "N":
                position.updateY(1);
                break;
            case "S":
                position.updateY(-1);
                break;
            case "W":
                position.updateX(-1);
                break;
            case "E":
                position.updateX(1);
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case "N":
                direction = "W";
                break;
            case "W":
                direction = "S";
                break;
            case "S":
                direction = "E";
                break;
            case "E":
                direction = "N";
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case "N":
                direction = "E";
                break;
            case "E":
                direction = "S";
                break;
            case "S":
                direction = "W";
                break;
            case "W":
                direction = "N";
                break;
        }
    }

    private String asString() {
        return position.getX() + " " + position.getY() + " " + direction;
    }
}
