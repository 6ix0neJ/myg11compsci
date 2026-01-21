// This is task 8 of the culminating
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class rectangularframe {
    public static void printInFrame(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            System.out.println("***");
            System.out.println("***");
            return;
        }

        int maxLength = 0;
        for (String str : strings) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        int frameWidth = maxLength + 4;
        printBorder(frameWidth);

        for (String str : strings) {
            System.out.print("* ");
            System.out.print(str);

            int paddingNeeded = maxLength - str.length();
            for (int i = 0; i < paddingNeeded; i++) {
                System.out.print(" ");
            }

            System.out.println(" *");
        }

        printBorder(frameWidth);
    }

    private static void printBorder(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Example: [\"Hello\", \"World\", \"in\", \"a\", \"frame\"]");
        List<String> example = new ArrayList<>();
        example.add("Hello");
        example.add("World");
        example.add("in");
        example.add("a");
        example.add("frame");
        printInFrame(example);
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence (words separated by spaces):");
        String userInput = sc.nextLine();

        String[] words = userInput.split(" ");

        List<String> userWords = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                userWords.add(word);
            }
        }

        System.out.println();
        System.out.println("Your sentence in a frame:");
        printInFrame(userWords);

        sc.close();
    }
}
