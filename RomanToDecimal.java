import java.util.Locale;

/**
 * RomanToDecimalTest is a program designed to test different roman numerals to see if they are valid, invalid, logically incorrect or not equal
 * @version Sunday, October 3
 * @author molliedoyle
 */

public class RomanToDecimal {
    /**
     * romanToDecimal contains a set of else if statements that allow the code to determine the value of the roman numeral
     * @param roman a string value that gets transformed
     * @return returns the decimal after it has been adjusted
     */
    public static int romanToDecimal(String roman) {
        int decimal = 0;
        for(int i = 0; i < roman.length(); i++) {
            //System.out.print("Debug: " + roman.substring(i, i+1).toUpperCase());
            if(roman.substring(i, i+1).toUpperCase().equals("I")) {
                decimal += 1;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("V")) {
                decimal += 5;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("X")) {
                decimal += 10;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("L")){
                decimal += 50;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("C")) {
                decimal += 100;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("D")) {
                decimal += 500;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("M")) {
                decimal += 1000;
            }
            else {
                // the program encounters an invalid character
                return -1;
            }
        }
        if(roman.toUpperCase().indexOf("IV") != -1)
            decimal -= 2;
        if(roman.toUpperCase().indexOf("IX") != -1)
            decimal -= 2;
        if(roman.toUpperCase().indexOf("XL") != -1)
            decimal -= 20;
        if(roman.toUpperCase().indexOf("XC") != -1)
            decimal -= 20;
        if(roman.toUpperCase().indexOf("CD") != -1)
            decimal -= 200;
        if(roman.toUpperCase().indexOf("CM") != -1)
            decimal -= 200;
        return decimal;
    }

    /**
     * the main method for RomanToDecimal
     * @param args command line arguments, as needed
     */
    public static void main(String[] args) {
        for(String temp : args) {
            int val = romanToDecimal(temp);
            if(val == -1)
                System.out.println("Input: " + temp + " => output: invalid");
            else
            //else if(isLogicallyValid) check in video 9/30
                System.out.println("Input: " + temp + " => output: " + romanToDecimal(temp));
        }
    //String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    //int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    //"IIVI".equals("VI") -> false

    }
}
