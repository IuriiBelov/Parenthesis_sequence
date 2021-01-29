import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String sequence = getSequence();
        printResult(checkCorrectness(sequence));
    }

    private static String getSequence() {
        Scanner scanner = new Scanner(System.in);
        String sequence;

        if (scanner.hasNextLine()) {
            sequence = scanner.nextLine();
        } else {
            sequence = null;
        }

        scanner.close();

        return sequence;
    }

    private static boolean checkCorrectness(String sequence) {
        if (sequence == null) {
            return true;
        }

        int numOfRoundParentheses = 0;
        int numOfSquareParentheses = 0;
        int numOfFiguredParentheses = 0;

        for (int i = 0; i < sequence.length(); ++i) {
            char c = sequence.charAt(i);

            switch (c) {
                case '(' -> ++numOfRoundParentheses;
                case '[' -> ++numOfSquareParentheses;
                case '{' -> ++numOfFiguredParentheses;
                case ')' -> --numOfRoundParentheses;
                case ']' -> --numOfSquareParentheses;
                case '}' -> --numOfFiguredParentheses;
            }

            if (numOfRoundParentheses < 0 || numOfSquareParentheses < 0 ||
                numOfFiguredParentheses < 0) {
                return false;
            }
        }

        return (numOfRoundParentheses == 0 && numOfSquareParentheses == 0 &&
                numOfFiguredParentheses == 0);
    }

    private static void printResult(boolean result) {
        System.out.println(result);
    }
}
