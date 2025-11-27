import java.util.Scanner;
public class binaryConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String bin = sc.next();
        System.out.println("Decimal equivalent: " + binToDec(bin));
        System.out.print("Enter a decimal number: ");
        int dec = sc.nextInt();
        System.out.println("Binary equivalent: " + decToBin(dec));
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
