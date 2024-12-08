package src.main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    private static final List<Integer> VALID_DIFFERENCES = List.of(1, 2, 3);
    private Utils(){ /*Classe utilitaire*/ }
    public static List<String> readFile(final String inputFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            return reader.lines().toList();
        }
    }


    public static List<Integer> parseNumbers(String line) {
        return Arrays.stream(line.split(" "))
                .filter(s -> s.matches("\\d+")) // Garder uniquement les nombres
                .map(Integer::valueOf)
                .toList();
    }
    public static boolean isValidDifference(int a, int b) {
        return VALID_DIFFERENCES.contains(Math.abs(a - b));
    }
}
