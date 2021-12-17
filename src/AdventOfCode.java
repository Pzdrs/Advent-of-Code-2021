import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AdventOfCode {
    public static void main(String[] args) {
        int[] data = getData();
        if (data != null) {
            int measurementsLargerThanPrevious = 0;
            int last = 0;
            for (int i = 0; i < data.length; i++) {
                if (i == 0) {
                    last = data[i];
                    continue;
                }
                if (data[i] > last) measurementsLargerThanPrevious++;
                last = data[i];
            }
            System.out.println(measurementsLargerThanPrevious);
        }
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
