import java.util.Scanner;
public class nestedloopdemo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many rows? ");
        int r = sc.nextInt();

        System.out.print("How many columns? ");
        int c = sc.nextInt();

        for (int row = 1; row <= r; row++) {
            for (int col = 1; col <= c; col++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }

        System.out.println(" ");
        System.out.println(r * c + " Units Printed");
        System.out.println("PROCESS COMPLETED");
    }
}
