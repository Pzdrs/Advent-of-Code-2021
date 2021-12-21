import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {
    public static void main(String[] args) {
        int[] crabs = loadData();
        List<Integer> fuel = new ArrayList<>();
        System.out.println(Arrays.toString(crabs));

        for (int i = Arrays.stream(crabs).min().getAsInt(); i < Arrays.stream(crabs).max().getAsInt(); i++) {
            int fuelNeeded = 0;
            for (int crab : crabs) {
                int multiplier = 1;
                for (int step = 0; step < Math.abs(crab - i); step++) {
                    fuelNeeded += multiplier;
                    multiplier++;
                }
            }
            fuel.add(fuelNeeded);
        }
        System.out.println(fuel.stream().min(Integer::compareTo).get());
    }

    public static int[] loadData() {
        List<Integer> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader("src/data.txt"));
            for (String s : scanner.next().split(",")) {
                list.add(Integer.parseInt(s));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
