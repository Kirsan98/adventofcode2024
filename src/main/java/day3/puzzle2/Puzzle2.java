package src.main.java.day3.puzzle2;

import src.main.java.Utils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle2 {

    private static final String FILENAME = "src/main/java/day3/puzzle2/input.txt";

    public static void main(String[] args) throws IOException {
        Integer result = 0;
        boolean doMul = true;
        List<String> lines = Utils.readFile(FILENAME);

        for (String line : lines) {

            // Regex pour capturer "mul(x,x)", "do", ou "don't"
            String regex = "(mul\\((\\d+),(\\d+)\\))|\\b(do|don't)\\b|do";

            // Pattern et Matcher
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            // Parcourir toutes les correspondances
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    // Correspondance pour "mul(x,x)"
                    int num1 = Integer.parseInt(matcher.group(2)); // Premier nombre
                    int num2 = Integer.parseInt(matcher.group(3)); // Deuxième nombre
                    if(doMul){
                        result += num1 * num2;
                    }
                } else if (matcher.group(4) != null || matcher.group().equals("do")) {
                    if(Objects.equals(matcher.group(), "do")){
                        doMul = true;
                    }
                    if(Objects.equals(matcher.group(), "don't")){
                        doMul = false;
                    }
                }
            }
        }
        System.out.println(result);
    }
}