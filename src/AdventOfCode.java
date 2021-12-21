import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {
    public static void main(String[] args) {
        List<LanternFish> lanternFish = loadInitial();

        System.out.println("Initial state: " + lanternFish);
        for (int i = 0; i < 80; i++) {
            for (int fishIndex = 0; fishIndex < lanternFish.size(); fishIndex++) {
                LanternFish fish = lanternFish.get(fishIndex);
                fish.decreaseTimer();
                if (fish.getTimer() == -1) {
                    fish.resetTimer();
                    lanternFish.add(new LanternFish());
                }
            }
        }
        System.out.println(lanternFish.size());
    }

    public static List<LanternFish> loadInitial() {
        List<LanternFish> initial = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader("src/data.txt"));
            String[] fish = scanner.next().split(",");
            for (String s : fish) {
                initial.add(new LanternFish(Integer.parseInt(s)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return initial;
    }
}
