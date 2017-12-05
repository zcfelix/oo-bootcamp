import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class CommandParser {

    private static final List<String> VALID_COMMANDS = asList("L", "R", "M");

    private static final Map<String, Command> STRING_TO_COMMAND_MAP = new HashMap<String, Command>() {{
        put("M", MarsRover::move);
        put("R", MarsRover::turnRight);
        put("L", MarsRover::turnLeft);
    }};

    public static List<Command> parseCommand(String input) {
        String[] commandArray = input.split("(?!^)");
        List<Command> commands = new ArrayList<>();
        for (String s : commandArray) {
            if (!VALID_COMMANDS.contains(s)) {
                throw new IllegalArgumentException("Invalid command sequence: " + input);
            }
            commands.add(STRING_TO_COMMAND_MAP.get(s));
        }
        return commands;
    }
}
