import java.util.Scanner;
public class arrays {

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

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            System.out.print("Enter a number: ");
            nums[i] = sc.nextInt();
            sum += nums[i];
        }


        System.out.println(" ");
        System.out.println("Sum is: " + sum);
        findminnmax(nums);
    }

}
