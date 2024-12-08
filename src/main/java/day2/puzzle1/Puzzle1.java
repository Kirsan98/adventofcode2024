package src.main.java.day2.puzzle1;

import src.main.java.Utils;

import java.io.IOException;
import java.util.List;

public class Puzzle1 {

    private static final String INPUT_FILE = "src/main/java/day2/puzzle1/input.txt";

    public static void main(String[] args) {
        try {
            List<String> lines = Utils.readFile(INPUT_FILE);
            int safeReportCount = countSafeReports(lines);
            System.out.println("Nombre de rapports sûrs : " + safeReportCount);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    private static int countSafeReports(List<String> lines) {
        int safeReportCount = 0;
        for (String line : lines) {
            if (isReportSafe(line)) {
                safeReportCount++;
            }
        }
        return safeReportCount;
    }

    private static boolean isReportSafe(String line) {
        List<Integer> numbers = Utils.parseNumbers(line);
        boolean hasIncrement = false;
        boolean hasDecrement = false;

        for (int i = 0; i < numbers.size() - 1; i++) {
            int current = numbers.get(i);
            int next = numbers.get(i + 1);

            if (current < next) {
                hasIncrement = true;
            } else if (current > next) {
                hasDecrement = true;
            }

            if (hasIncrement && hasDecrement || !Utils.isValidDifference(current, next)) {
                return false;
            }
        }
        return true;
    }
}
