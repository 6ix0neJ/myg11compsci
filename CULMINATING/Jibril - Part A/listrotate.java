// This is Task 5 of the culminating
import java.util.Scanner;
public class listrotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list of numbers (space-separated): ");
        String[] input = sc.nextLine().split(" ");
        System.out.print("Enter the number of positions to rotate: ");
        int k = sc.nextInt();
        sc.close();

        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int[] rotated = rotateList(numbers, k);
        System.out.print("Rotated list: ");
        for (int num : rotated) {
            System.out.print(num + " ");
        }

    }

    public static int[] rotateList(int[] list, int k) {
        int n = list.length;
        if (n == 0) return list;

        k = k % n;
        if (k < 0) k += n;

        int[] rotated = new int[n];

        for (int i = 0; i < n - k; i++) {
            rotated[i] = list[i + k];
        }

        for (int i = 0; i < k; i++) {
            rotated[n - k + i] = list[i];
        }

        return rotated;
    }
}
