// This is Task 12 of the culminating
import java.util.Scanner;
public class newleaprule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the duration of a year (in fractional days): ");
        double duration = sc.nextDouble();

        System.out.println("\nCalculating optimal leap year rule...\n");
        calculateLeapYearRule(duration);

        sc.close();
    }

    public static void calculateLeapYearRule(double yearLength) {
        int baseDays = (int) yearLength;
        double fractionalPart = yearLength - baseDays;

        System.out.println("Year length: " + yearLength + " days");
        System.out.println("Base calendar year: " + baseDays + " days");
        System.out.println("Fractional part: " + fractionalPart + " days\n");

        if (fractionalPart == 0) {
            System.out.println("No leap year needed! The year is exactly " + baseDays + " days.");
            return;
        }

        Fraction bestFraction = findBestFraction(fractionalPart, 1000);

        System.out.println("Best approximation: " + bestFraction.numerator + "/" + bestFraction.denominator);
        System.out.println("Approximation value: " + ((double)bestFraction.numerator / bestFraction.denominator));
        System.out.println("Error: " + Math.abs(fractionalPart - ((double)bestFraction.numerator / bestFraction.denominator)) + " days\n");

        generateLeapYearRule(baseDays, bestFraction);
    }

    public static Fraction findBestFraction(double target, int maxDenominator) {
        Fraction best = new Fraction(0, 1);
        double bestError = Math.abs(target);

        for (int denom = 1; denom <= maxDenominator; denom++) {
            int numer = (int) Math.round(target * denom);
            double error = Math.abs(target - ((double)numer / denom));

            if (error < bestError) {
                bestError = error;
                best = new Fraction(numer, denom);
            }

            if (error < 1e-10) {
                break;
            }
        }

        return best;
    }

    public static void generateLeapYearRule(int baseDays, Fraction fraction) {
        int leapDays = fraction.numerator;
        int cycle = fraction.denominator;

        System.out.println("LEAP YEAR RULE:");
        System.out.println("================");
        System.out.println("Base year: " + baseDays + " days");

        if (leapDays > 0) {
            System.out.println("Add " + leapDays + " day(s) every " + cycle + " years");
            System.out.println("\nIn other words:");
            System.out.println("- " + (cycle - leapDays) + " years have " + baseDays + " days");
            System.out.println("- " + leapDays + " year(s) have " + (baseDays + 1) + " days");
            System.out.println("- This pattern repeats every " + cycle + " years");
        } else if (leapDays < 0) {
            System.out.println("Remove " + Math.abs(leapDays) + " day(s) every " + cycle + " years");
            System.out.println("\nIn other words:");
            System.out.println("- " + (cycle - Math.abs(leapDays)) + " years have " + baseDays + " days");
            System.out.println("- " + Math.abs(leapDays) + " year(s) have " + (baseDays - 1) + " days");
            System.out.println("- This pattern repeats every " + cycle + " years");
        }

        double avgYearLength = baseDays + ((double)leapDays / cycle);
        System.out.println("\nAverage year length with this rule: " + avgYearLength + " days");
    }

    static class Fraction {
        int numerator;
        int denominator;

        Fraction(int num, int denom) {
            this.numerator = num;
            this.denominator = denom;
        }
    }
}
