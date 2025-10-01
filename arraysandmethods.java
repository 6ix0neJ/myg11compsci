import java.util.Scanner;
public class arraysandmethods {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            System.out.print("Enter a number: ");
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        swaparrayvalues(nums, 0, 2);
        System.out.print("Array: ");
        printarray(nums);
        System.out.println(" ");
        System.out.print("Array Reversed: ");
        reversearray(nums);
        printarray(nums);
        System.out.println(" ");
        System.out.println("Sum is: " + sum);
        findminnmax(nums);
        findminnmax(nums);
        sc.close();

    }
    public static void findminnmax(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        System.out.println("Smallest number is: " + min);
        System.out.println("Largest number is: " + max);
    }
    public static void printarray (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length - 1) System.out.print(", ");
        }
    }
    public static void swaparrayvalues(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void reversearray (int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            swaparrayvalues(arr, start, end);
            start++;
            end--;
        }
    }

}
