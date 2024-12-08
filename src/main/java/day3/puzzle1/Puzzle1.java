package src.main.java.day3.puzzle1;

import src.main.java.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle1 {

    private static final String REGEX = "mul\\(\\d+,\\d+\\)";

    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/day3/puzzle1/input.txt";
        Integer result = 0;
        List<String> lines = Utils.readFile(fileName);
        for(String line: lines){
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String regexDigit = "mul\\((\\d+),(\\d+)\\)";
                Pattern patternDigit = Pattern.compile(regexDigit);
                Matcher matcherDigit = patternDigit.matcher(matcher.group());
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