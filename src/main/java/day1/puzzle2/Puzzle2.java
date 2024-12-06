package src.main.java.day1.puzzle2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Puzzle2 {
    public static void main(String[] args) {
        String fileName = "src/main/java/day1/puzzle1/input.txt";
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        int distance = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.lines().forEach(line -> {
                String[] parts = line.split(" {3}");
                leftList.add(Integer.parseInt(parts[0].trim()));
                rightList.add(Integer.parseInt(parts[1].trim()));
            });
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            return; // Sortie en cas d'erreur de lecture
        }

        for (Integer integer : leftList) {
            int nbOccurence = Long.valueOf(rightList.stream().filter(e -> Objects.equals(e, integer)).count()).intValue();
            distance += integer * nbOccurence;
        }
        System.out.println("Résultat : " + distance);
    }
}