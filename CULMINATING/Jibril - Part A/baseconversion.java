// This is task 7 of the culminating
import java.util.ArrayList;
import java.util.List;

public class baseconversion {

    public static List<Integer> convertBase(List<Integer> digits, int b1, int b2) {

        int decimalValue = 0;
        int power = 0;

        for (int i = digits.size() - 1; i >= 0; i--) {
            decimalValue += digits.get(i) * Math.pow(b1, power);
            power++;
        }

        List<Integer> result = new ArrayList<>();

        if (decimalValue == 0) {
            result.add(0);
            return result;
        }

        while (decimalValue > 0) {
            result.add(0, decimalValue % b2);  // Add remainder at the beginning
            decimalValue /= b2;
        }

        return result;
    }

    public static void printList(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        List<Integer> test1 = new ArrayList<>();
        test1.add(2);
        test1.add(1);
        test1.add(0);

        System.out.println("Test 1: Converting [2,1,0] from base-3 to base-10");
        System.out.print("Input: ");
        printList(test1);
        List<Integer> result1 = convertBase(test1, 3, 10);
        System.out.print("Output: ");
        printList(result1);
        System.out.println("Verification: 2*3^2 + 1*3^1 + 0*3^0 = 18 + 3 + 0 = 21");
        System.out.println();

        List<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(0);
        test2.add(1);
        test2.add(0);

        System.out.println("Test 2: Converting [1,0,1,0] from base-2 to base-10");
        System.out.print("Input: ");
        printList(test2);
        List<Integer> result2 = convertBase(test2, 2, 10);
        System.out.print("Output: ");
        printList(result2);
        System.out.println("Verification: 1*2^3 + 0*2^2 + 1*2^1 + 0*2^0 = 8 + 0 + 2 + 0 = 10");
        System.out.println();

        List<Integer> test3 = new ArrayList<>();
        test3.add(2);
        test3.add(5);

        System.out.println("Test 3: Converting [2,5] from base-10 to base-2");
        System.out.print("Input: ");
        printList(test3);
        List<Integer> result3 = convertBase(test3, 10, 2);
        System.out.print("Output: ");
        printList(result3);
        System.out.println("Verification: 25 in decimal = 11001 in binary");
        System.out.println();

        List<Integer> test4 = new ArrayList<>();
        test4.add(1);
        test4.add(5);

        System.out.println("Test 4: Converting [1,5] from base-16 to base-10");
        System.out.print("Input: ");
        printList(test4);
        List<Integer> result4 = convertBase(test4, 16, 10);
        System.out.print("Output: ");
        printList(result4);
        System.out.println("Verification: 1*16^1 + 5*16^0 = 16 + 5 = 21");
        System.out.println();

        List<Integer> test5 = new ArrayList<>();
        test5.add(0);

        System.out.println("Test 5: Converting [0] from base-5 to base-8");
        System.out.print("Input: ");
        printList(test5);
        List<Integer> result5 = convertBase(test5, 5, 8);
        System.out.print("Output: ");
        printList(result5);
        System.out.println();
    }
}
