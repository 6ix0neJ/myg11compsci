// This is Task 2 of the culminating
public class tasktwo {
    public static void main(String[] args) {
        final int LIMIT = 1000000;
        double sum = 0.0;

        for (int k = 1; k <= LIMIT; k++) {
            double term = Math.pow(-1, k + 1) / (2.0 * k - 1);
            sum += term;
        }

        double result = 4 * sum;

        System.out.println("Computing the alternating series:");
        System.out.println("4 * Σ(k=1 to " + LIMIT + ") [(-1)^(k+1) / (2k-1)]");
        System.out.println();
        System.out.println("Result: " + result);
        System.out.println();
        System.out.println("Note: This is the Leibniz formula for π");
        System.out.println("Actual value of π: " + Math.PI);
        System.out.println("Difference: " + Math.abs(result - Math.PI));
    }
}
