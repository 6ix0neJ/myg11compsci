import java.util.Scanner;

public class useragefrombirthyear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        //sc.nextLine();

        System.out.print("Enter you birth year: ");
        int byear = sc.nextInt();

        //sc.nextLine();

        int finalage = 2025 - byear;

        System.out.println(" ");
        System.out.println("Your name is " + name);
        System.out.println("You are " + finalage +  " Years Old");

        sc.close();
    }
}