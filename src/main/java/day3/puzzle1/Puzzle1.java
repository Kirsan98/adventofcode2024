package src.main.java.day3.puzzle1;

import src.main.java.Utils;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle1 {

    private static final String REGEX_MUL = "mul\\(\\d+,\\d+\\)"; // Permet de récupérer les "mul(u,v)mul(x,y)..."
    private static final String REGEX_DIGIT = "mul\\((\\d+),(\\d+)\\)"; // Permet de récupérer les nombres
    private static final String FILENAME = "src/main/java/day3/puzzle1/input.txt";

    public static void main(String[] args) throws IOException {
        Integer result = 0;
        List<String> lines = Utils.readFile(FILENAME);
        for(String line: lines){
            Pattern patternMul = Pattern.compile(REGEX_MUL);
            Matcher matcherMul = patternMul.matcher(line);
            while (matcherMul.find()) {
                Pattern patternDigit = Pattern.compile(REGEX_DIGIT);
                Matcher matcherDigit = patternDigit.matcher(matcherMul.group());
                if (matcherDigit.matches()) {
                    int num1 = Integer.parseInt(matcherDigit.group(1));
                    int num2 = Integer.parseInt(matcherDigit.group(2));
                    result += num1 * num2;
            }
        }
    }
    System.out.println(result);
}
}