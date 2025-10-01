/*
This program is meant to list out all
prime numbers within a range set by the user.
This was an assignment from my grade 11 computer
science class.
 */

import java.util.Scanner;

public class primenumberlister {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What range of primes would you like listed?");
        System.out.print("Enter Range Start: ");
        int rangeS = scanner.nextInt();
        System.out.print("Enter Range End: ");
        int rangeE = scanner.nextInt();

        findPrimes(rangeS, rangeE);

        System.out.println();
    }
    public static void findPrimes (int a, int b) {

    }
}
