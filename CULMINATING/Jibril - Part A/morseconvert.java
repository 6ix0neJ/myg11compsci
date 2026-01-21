// This is Task 9 of the culminating
import java.util.Scanner;
public class morseconvert {
    static String[] MORSE = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",     // A-I
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",   // J-R
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",          // S-Z
            "-----", ".----", "..---", "...--", "....-", ".....", "-....",     // 0-6
            "--...", "---..", "----."                                         // 7-9
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to convert to Morse code: ");
        String input = sc.nextLine();
        String morse = toMorse(input);
        System.out.println("Morse code: " + morse);
    }
    public static String toMorse(String input) {
        String mconverted = "";
        input = input.toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                mconverted += "  ";
            } else if (c >= 'A' && c <= 'Z') {
                int index = c - 'A';  // A=0, B=1, C=2, etc.
                mconverted += MORSE[index] + " ";
            } else if (c >= '0' && c <= '9') {
                int index = 26 + (c - '0');
                mconverted += MORSE[index] + " ";
            }
        }
        return mconverted.trim();
    }
}
