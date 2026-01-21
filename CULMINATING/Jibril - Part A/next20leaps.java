// This is Task 1 of the culminating
public class next20leaps {
    static boolean isLeapYear = false;
    public static void main(String[] args) {
        int year = 2024;
        for (int i = 0; i < 20; i++) {
            year += 4;
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeapYear = true;
                    } else {
                        isLeapYear = false;
                    }
                } else {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = false;
            }
            System.out.println(year + " is a leap year: " + isLeapYear);
        }
    }
}
