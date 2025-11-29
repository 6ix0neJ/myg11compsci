import java.util.Scanner;

public class primenumberlister {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many numbers would you like to process? ");
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        System.out.println();

        int primeCount = 0;
        System.out.println("Results:");
        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.println(num + " is prime.");
                primeCount++;
            } else {
                System.out.println(num + " is not prime.");
            }
        }


        System.out.println("\nTotal primes entered: " + primeCount);
        System.out.print("Prime numbers: ");
        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
