package src.main.java.day2.puzzle1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle1 {

    private static final String WHITE_SPACE = " ";
    private static final List<Integer> VALID_DIFFER = List.of(1, 2, 3);
    private static final String FILENAME = "src/main/java/day2/puzzle1/input.txt";
    public static void main(String[] args) {
        int nbSafeReports = 0;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            boolean reportIsSafe = false;
            br.lines().forEach(lines::add);
            for(String line: lines){
                boolean lineIncrement = false;
                boolean lineDecrement = false;
                List<String> numbersToVerify = Arrays.asList(line.split(WHITE_SPACE));
                for(int i=0; i<numbersToVerify.size() - 1; i++){
                    int currentNumber = Integer.parseInt(numbersToVerify.get(i));
                    int nextNumber = Integer.parseInt(numbersToVerify.get(i+1));
                    if(currentNumber<nextNumber){
                        lineIncrement = true;
                    }
                    else if(currentNumber > nextNumber){
                        lineDecrement = true;
                    }
                    if(isInvalidReport(lineIncrement, lineDecrement, currentNumber, nextNumber)){
                        reportIsSafe = false;
                        break;
                    }
                    reportIsSafe= true;
                }
                nbSafeReports+= reportIsSafe ? 1: 0;
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            return; // Sortie en cas d'erreur de lecture
        }
        System.out.println("Résultat : " + nbSafeReports);
    }

    private static boolean isInvalidReport(boolean lineIncrement, boolean lineDecrement, int currentNumber, int nextNumber) {
        return lineIncrement == lineDecrement || (!VALID_DIFFER.contains(Math.abs(currentNumber - nextNumber)));
    }
}
