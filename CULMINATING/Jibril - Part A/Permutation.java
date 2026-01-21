// This is Task 11 of the culminating

public class Permutation {
    static String[] operations = {"+", "-", ""};

    public static void main(String[] args) {
        int count = 0;
        int totalCombinations = (int) Math.pow(3, 8);

        System.out.println("Finding all ways to make 100 using digits 1-9...\n");

        for (int i = 0; i < totalCombinations; i++) {
            String[] ops = getOperations(i);
            String expression = buildExpression(ops);
            int result = evaluate(expression);

            if (result == 100) {
                count++;
                System.out.println(expression + " = " + result);
            }
        }

        System.out.println("\nTotal solutions found: " + count);
    }

    public static String[] getOperations(int num) {
        String[] result = new String[8];
        for (int i = 0; i < 8; i++) {
            result[i] = operations[num % 3];
            num /= 3;
        }
        return result;
    }

    public static String buildExpression(String[] ops) {
        String expr = "1";
        for (int i = 0; i < 8; i++) {
            expr += ops[i] + (i + 2);  // digits 2-9
        }
        return expr;
    }

    public static int evaluate(String expr) {
        int sum = 0;
        int currentNumber = 0;
        int sign = 1;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c >= '0' && c <= '9') {
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '+') {
                sum += sign * currentNumber;
                currentNumber = 0;
                sign = 1;
            } else if (c == '-') {
                sum += sign * currentNumber;
                currentNumber = 0;
                sign = -1;
            }
        }

        sum += sign * currentNumber;

        return sum;
    }
}
