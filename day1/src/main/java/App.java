package src.main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        String fileName = "input.txt";
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

        Collections.sort(leftList);
        Collections.sort(rightList);
        for (int i = 0; i < leftList.size(); i++) {
            distance += Math.abs(leftList.get(i) - rightList.get(i));
        }
        System.out.println("Résultat : " + distance);
    }
}