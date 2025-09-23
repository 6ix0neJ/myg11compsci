import java.util.Scanner;

public class loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 0;

        System.out.println("WHILE LOOP");

        while(i < 10) {
            System.out.println(i + " loops!");
            i = i + 1;
        }
        System.out.println(" ");

        /*
        *for loop syntax remind*
        for (initial value; condition; counting variable)
         */

        System.out.println("FOR LOOP");

        for (int j = 0; j <= 10; j++) {
            System.out.println(j + " Cycles Completed");
        }
        System.out.println("END");
    }
}
