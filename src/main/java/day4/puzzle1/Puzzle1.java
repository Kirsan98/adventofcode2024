package src.main.java.day4.puzzle1;

import src.main.java.Utils;

import java.io.IOException;
import java.util.List;

public class Puzzle1 {

    private static final String FILENAME = "src/main/java/day4/puzzle1/input.txt";
    private static final String XMAS = "XMAS";
    private static final char TARGET_CHAR = 'X';

    public static void main(String[] args) throws IOException {
        Integer result = 0;
        List<String> lines = Utils.readFile(FILENAME);
        int lineLength = lines.getFirst().length();
        char[][] matrix = initializeMatrix(lines, lineLength);
        int numRows = lines.size();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < lineLength; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == TARGET_CHAR) {
                    result = checkHorizontalRight(j, lineLength, currentChar, matrix, i, result);
                    result = checkHorizontalLeft(j, currentChar, matrix, i, result);
                    result = checkBottom(i, lines, currentChar, matrix, j, result);
                    result = checkTop(i, currentChar, matrix, j, result);
                    result = checkBottomRight(i, lines, j, lineLength, currentChar, matrix, result);
                    result = checkBottomLeft(i, lines, j, currentChar, matrix, result);
                    result = checkTopRight(i, j, lineLength, currentChar, matrix, result);
                    result = checkTopLeft(i, j, currentChar, matrix, result);
                }
            }
        }
        System.out.println(result);
    }

    private static Integer checkTopLeft(int i, int j, char currentChar, char[][] matrix, Integer result) {
        if (i - 3 >= 0 && j - 3 >= 0) {
            StringBuilder strToCheck = new StringBuilder().append(currentChar);
            strToCheck.append(matrix[i - 1][j - 1]).append(matrix[i - 2][j - 2]).append(matrix[i - 3][j - 3]);
            result += hasOccurence(strToCheck) ? 1 : 0;
        }
        return result;
    }

    private static Integer checkTopRight(int i, int j, int lineLength, char currentChar, char[][] matrix, Integer result) {
        if (i - 3 >= 0 && j + 3 < lineLength) {
            StringBuilder strToCheck = new StringBuilder().append(currentChar);
            strToCheck.append(matrix[i - 1][j + 1]).append(matrix[i - 2][j + 2]).append(matrix[i - 3][j + 3]);
            result += hasOccurence(strToCheck) ? 1 : 0;
        }
        return result;
    }

    private static Integer checkBottomLeft(int i, List<String> lines, int j, char currentChar, char[][] matrix, Integer result) {
        if (i + 3 < lines.size() && j - 3 >= 0) {
            StringBuilder strToCheck = new StringBuilder().append(currentChar);
            strToCheck.append(matrix[i + 1][j - 1]).append(matrix[i + 2][j - 2]).append(matrix[i + 3][j - 3]);
            result += hasOccurence(strToCheck) ? 1 : 0;
        }
        return result;
    }

    private static Integer checkBottomRight(int i, List<String> lines, int j, int lineLength, char currentChar, char[][] matrix, Integer result) {
        if (i + 3 < lines.size() && j + 3 < lineLength) {
            StringBuilder strToCheck = new StringBuilder().append(currentChar);
            strToCheck.append(matrix[i + 1][j + 1]).append(matrix[i + 2][j + 2]).append(matrix[i + 3][j + 3]);
            result += hasOccurence(strToCheck) ? 1 : 0;
        }
        return result;
    }

    private static Integer checkTop(int i, char currentChar, char[][] matrix, int j, Integer result) {
        if (i - 3 >= 0) {
            StringBuilder strToCheck = new StringBuilder().append(currentChar);
            strToCheck.append(matrix[i - 1][j]).append(matrix[i - 2][j]).append(matrix[i - 3][j]);
            result += hasOccurence(strToCheck) ? 1 : 0;
        }
        return result;
    }

    private static Integer checkBottom(int i, List<String> lines, char currentChar, char[][] matrix, int j, Integer result) {
        if (i + 3 < lines.size()) {
            StringBuilder strToCheck = new StringBuilder().append(currentChar);
            strToCheck.append(matrix[i + 1][j]).append(matrix[i + 2][j]).append(matrix[i + 3][j]);
            result += hasOccurence(strToCheck) ? 1 : 0;
        }
        return result;
    }

    private static Integer checkHorizontalLeft(int j, char currentChar, char[][] matrix, int i, Integer result) {
        if (j - 3 >= 0) {
            StringBuilder strToCheck = new StringBuilder().append(currentChar);
            strToCheck.append(matrix[i][j - 1]).append(matrix[i][j - 2]).append(matrix[i][j - 3]);
            result += hasOccurence(strToCheck) ? 1 : 0;
        }
        return result;
    }

    private static Integer checkHorizontalRight(int j, int lineLength, char currentChar, char[][] matrix, int i, Integer result) {
        if (j + 3 < lineLength) {
            StringBuilder strToCheck = new StringBuilder().append(currentChar);
            strToCheck.append(matrix[i][j + 1]).append(matrix[i][j + 2]).append(matrix[i][j + 3]);
            result += hasOccurence(strToCheck) ? 1 : 0;
        }
        return result;
    }

    private static char[][] initializeMatrix(List<String> lines, int lineLength) {
        char[][] matrix = new char[lines.size()][lineLength];
        for (int i = 0; i < lines.size(); i++) {
            matrix[i] = lines.get(i).toCharArray();
        }
        return matrix;
    }

    private static boolean hasOccurence(StringBuilder line) {
        return XMAS.contentEquals(line);
    }
}