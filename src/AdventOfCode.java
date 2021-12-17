import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {
    public static void main(String[] args) {
        Command[] commands = getCommands();
        for (Command command : commands) {
            System.out.println(command);
        }
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
}
