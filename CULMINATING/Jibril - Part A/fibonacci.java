// This is Task 6 of the culminating
public class fibonacci {
    public static void main(String[] args) {
        int count = 0;
        int a = 0;
        int b = 1;
        System.out.print("Fibonacci sequence: ");

        while (count < 100) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
            count++;
        }
        System.out.println();
    }
}