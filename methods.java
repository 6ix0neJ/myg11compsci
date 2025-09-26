// i know the code is sloppy im sorry
import java.util.Scanner;
public class methods {
    public static void func(String name) {System.out.println("Hello! " + name);}
    public static int add (int a, int b) {return a + b;}
    public static int square (int x) {return x * x;}
    public static void printstars(int r, int c) {
        for (int row = 1; row <= r; row++) {
            for (int col = 1; col <= c; col++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = "Jibril";
        func(n);
        func("Willard");
        func("Bob");

        System.out.print("How many rows? ");
        int ur = sc.nextInt();
        System.out.print("How many columns? ");
        int uc = sc.nextInt();
        printstars(ur, uc);

        int sqans = square(4);
        System.out.println("The square root of 4 is " + sqans);

        int sum = add(7, 3);
        System.out.println("Sum is: " + sum);
    }
}