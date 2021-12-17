import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {
    static int horizontalPos = 0, depth = 0, aim = 0;

    public static void main(String[] args) {
        Arrays.stream(getCommands()).forEach(AdventOfCode::processCommand);
        System.out.println(horizontalPos * depth);
    }

    public static Command[] getCommands() {
        List<Command> commands = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader("src/data.txt"));
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(" ");
                commands.add(new Command(split[0], Integer.parseInt(split[1])));
            }
            return commands.toArray(Command[]::new);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return commands.toArray(new Command[0]);
    }

    public static void processCommand(Command command) {
        switch (command.direction()) {
            case "up" -> aim -= command.step();
            case "down" -> aim += command.step();
            case "forward" -> {
                horizontalPos += command.step();
                depth += aim * command.step();
            }
        }
    }
}
