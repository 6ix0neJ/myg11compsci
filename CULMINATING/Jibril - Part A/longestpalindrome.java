// This is Task 10 of the culminating
import java.util.Scanner;
public class longestpalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;


        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);

            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Longest Palindromic Substring Finder ===");
        System.out.println("\nExamples:");

        String[] examples = {"babad", "cbbd", "racecar", "noon", "a", "ac", "abacabad"};
        for (String example : examples) {
            String result = longestPalindrome(example);
            System.out.println("Input: \"" + example + "\" -> Longest palindrome: \"" + result + "\"");
        }

        System.out.println("\n=== Now try your own! ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String longest = longestPalindrome(input);
        System.out.println("\nInput string: \"" + input + "\"");
        System.out.println("Longest palindromic substring: \"" + longest + "\"");
        System.out.println("Length: " + longest.length());

        sc.close();
    }
}
