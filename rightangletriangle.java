import java.util.Scanner;
public class rightangletriangle {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many rows? ");
        int r = sc.nextInt();

        for (int row = 1; row <= r; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }

        System.out.println("PROCESS COMPLETED");
    }
}
