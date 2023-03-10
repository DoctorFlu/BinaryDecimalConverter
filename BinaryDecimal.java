import java.util.Scanner;

public class BinaryDecimal {
    public static void main(String[] args) {
        Scanner scantron = new Scanner(System.in);
        System.out.println("Welcome to the greatest Binary-Decimal Converter in the history of Binary-Decimal Converters, maybe ever!");
        System.out.println("You know what to do:");
        System.out.println("1. B to D");
        System.out.println("2. D to B");
        int choice = scantron.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Give me the B!");
                String binaryString = scantron.next();
                int decimalNumber = bToD(binaryString);
                System.out.println("Your D for the B " + binaryString + " is " + decimalNumber);
                break;
            case 2:
                System.out.println("Give me the D!");
                String decimalString = scantron.next();
                String binaryString2 = dToB(decimalString);
                System.out.println("Your B for the D " + decimalString + " is " + binaryString2);
                break;
            default:
                System.out.println("No. You shall not pass.");
        }
    }

    public static int bToD(String binaryString) {
        int decimalNumber = 0;
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(binaryString.charAt(i));
            decimalNumber += digit * Math.pow(2, length - 1 - i);
        }

        return decimalNumber;
    }
    
    public static String dToB(String decimalString) {
    	String binaryNumber = "";
        int index = 0;
        int len = decimalString.length();
        while (index < len) {
            int currentDigit = decimalString.charAt(index) - '0';
            int value = currentDigit;
            for (int i = 0; i < index; i++) {
                value *= 10;
            }
            while (value > 0) {
                int remainder = value % 2;
                binaryNumber = remainder + binaryNumber;
                value /= 2;
            }
            index++;
        }
        return binaryNumber;
    }
}
