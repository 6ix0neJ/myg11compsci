import java.util.Scanner;
public class numberconversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select a number conversion type:");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        System.out.println("3. Hexadecimal to Decimal");
        System.out.println("4. Decimal to Hexadecimal");
        String choice = sc.next();

        while (Integer.parseInt(choice) < 1 || Integer.parseInt(choice) > 4) {
            System.out.println("Invalid Selection: Please enter 1, 2, 3, or 4.");
            choice = sc.next();
        }

        if (choice.equals("1")) {
            // Binary to Decimal
            System.out.print("Enter a binary number: ");
            String bin = sc.next();
            System.out.println("Decimal equivalent: " + binToDec(bin));
        } else if (choice.equals("2")) {
            // Decimal to Binary
            System.out.print("Enter a decimal number: ");
            int dec = sc.nextInt();
            System.out.println("Binary equivalent: " + decToBin(dec));
        } else if (choice.equals("3")) {
            // Hexadecimal to Decimal
            System.out.print("Enter a hexadecimal number: ");
            String hex = sc.next();
            System.out.println("Decimal equivalent: " + hexToDec(hex));
        } else if (choice.equals("4")) {
            // Decimal to Hexadecimal
            System.out.print("Enter a decimal number: ");
            int dec = sc.nextInt();
            System.out.println("Hexadecimal equivalent: " + decToHex(dec));
        }
        sc.close();
    }
    public static String decToHex(int decimal) {
        String hex = "";
        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            int remainder = decimal % 16;
            if (remainder < 10) {
                hex = remainder + hex;
            } else {
                hex = (char)('A' + (remainder - 10)) + hex;
            }
            decimal /= 16;
        }
        return hex;
    }
    public static int hexToDec(String hex) {
        hex = hex.replace("", "");
        int dec = 0;
        int col = (int) Math.pow(16, hex.length() - 1);
        for (int i = 0; i < hex.length(); i++) {
            char digit = hex.charAt(i);
            int offset;
            if (Character.isDigit(digit))
                offset = 48;
            else
                offset = 55;

            int decValue = Character.valueOf(digit) - offset;
            System.out.println(decValue);
            dec += decValue * col;
            col /= 16;
        }
        return dec;
    }
    public static int hexDictionary(char digit) {
        int decValue;
        switch (digit) {
            case '1':
                decValue = 1;
                break;
            case '2':
                decValue = 2;
                break;
            case '3':
                decValue = 3;
                break;
            case '4':
                decValue = 4;
                break;
            case '5':
                decValue = 5;
                break;
            case '6':
                decValue = 6;
                break;
            case '7':
                decValue = 7;
                break;
            case '8':
                decValue = 8;
                break;
            case '9':
                decValue = 9;
                break;
            case 'A':
                decValue = 10;
                break;
            case 'B':
                decValue = 11;
                break;
            case 'C':
                decValue = 12;
                break;
            case 'D':
                decValue = 13;
                break;
            case 'E':
                decValue = 14;
                break;
            case 'F':
                decValue = 15;
                break;
            default:
                decValue = 0;
        }
        return decValue;
    }
    public static int binToDec(String bin) {
        int dec = 0;
        int power = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                dec += Math.pow(2, power);
            }
            power++;
        }
        return dec;
    }
    public static String decToBin(int decimal) {
        String bin = "";
        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            bin = (decimal % 2) + bin;
            decimal /= 2;
        }
        return bin;
    }

}
