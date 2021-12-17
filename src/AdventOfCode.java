import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AdventOfCode {
    public static void main(String[] args) {

    }

    public static int[] getData() {
        try {
            return Files.lines(Path.of("src/data.txt")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
