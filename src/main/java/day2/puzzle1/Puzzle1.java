package src.main.java.day2.puzzle1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Puzzle1 {

    private static final String INPUT_FILE = "src/main/java/day2/puzzle1/input.txt";
    private static final List<Integer> VALID_DIFFERENCES = List.of(1, 2, 3);

    public static void main(String[] args) {
        try {
            List<String> lines = readFile();
            int safeReportCount = countSafeReports(lines);
            System.out.println("Nombre de rapports sûrs : " + safeReportCount);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    private static List<String> readFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(Puzzle1.INPUT_FILE))) {
            return reader.lines().toList();
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
        List<Integer> numbers = parseNumbers(line);
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

            if (hasIncrement && hasDecrement || !isValidDifference(current, next)) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> parseNumbers(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .toList();
    }

    private static boolean isValidDifference(int a, int b) {
        return VALID_DIFFERENCES.contains(Math.abs(a - b));
    }
}
