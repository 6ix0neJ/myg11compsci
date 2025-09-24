import java.util.Scanner;
public class sumfrom1n {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number more than 1:");
        long n = sc.nextInt();

        long j = 0;
        for (long i = 0; i <= n; i++) {
            j = i + j;
            System.out.println(i + " Added to final value. Final value is now: " + j);
        }

        System.out.println(" ");
        System.out.println("Final value is " + j);

        sc.close();
    }
}
