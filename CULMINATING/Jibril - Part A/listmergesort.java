// This is Task 4 of the culminating
import java.util.Arrays;
public class listmergesort {
    public static void main(String[] args) {
        int[] list1 = {1, 4, 6};
        int[] list2 = {2, 3, 5};
        int[] merged = mergeSorted(list1, list2);
        System.out.println("Merged: " + Arrays.toString(merged));

        int[] list3 = {1, 3, 5, 7, 9};
        int[] list4 = {2, 4, 6};
        int[] merged2 = mergeSorted(list3, list4);
        System.out.println("Merged (different lengths): " + Arrays.toString(merged2));
    }

    public static int[] mergeSorted(int[] list1, int[] list2) {
        int length1 = list1.length;
        int length2 = list2.length;
        int totalLength = length1 + length2;
        int[] result = new int[totalLength];

        int i = 0, j = 0, k = 0;

        while (i < length1 && j < length2) {
            if (list1[i] <= list2[j]) {
                result[k++] = list1[i++];
            } else {
                result[k++] = list2[j++];
            }
        }

        while (i < length1) {
            result[k++] = list1[i++];
        }

        while (j < length2) {
            result[k++] = list2[j++];
        }

        return result;
    }
}
