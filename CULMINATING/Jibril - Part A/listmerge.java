// This is Task 3 of the culminating
import java.util.Arrays;
public class listmerge {
    public static void main(String[] args) {
        String[] list1 = {"a", "b", "c"};
        String[] list2 = {"1", "2", "3"};
        String[] merged = alternateMerge(list1, list2);
        System.out.println("Merged: " + Arrays.toString(merged));

        String[] list3 = {"a", "b", "c", "d", "e"};
        String[] list4 = {"1", "2", "3"};
        String[] merged2 = alternateMerge(list3, list4);
        System.out.println("Merged (different lengths): " + Arrays.toString(merged2));
    }

    public static String[] alternateMerge(String[] list1, String[] list2) {
        int length1 = list1.length;
        int length2 = list2.length;
        int totalLength = length1 + length2;
        String[] result = new String[totalLength];

        int i = 0, j = 0, k = 0;

        while (i < length1 && j < length2) {
            result[k++] = list1[i++];
            result[k++] = list2[j++];
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
