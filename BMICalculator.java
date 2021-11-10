import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;

/**
 * BMICalculator takes input from the user and outputs their BMI
 * @version 11/09/2021
 * @author molliedoyle
 */
public class BMICalculator {
    public static double computeBMI(int inches, int pounds) {
        if (inches <= 0 || pounds <= 0)
            return 0;
        return pounds * 0.454 / Math.pow(inches * 0.0254, 2);

    }

    /**
     * extractInches parses the input for the feet and inches of the person's height
     * @param height string value that is inputted by the user
     * @return returns the height in inches
     */
    public static int extractInches(String height) {
        int qtPos = height.indexOf("'");
        int dblQtPos = height.indexOf("\"");
        if(qtPos == -1 || dblQtPos == -1) {
            return -1;
        }
        int feet = Integer.parseInt(height.substring(0, qtPos));
        int inches = Integer.parseInt(height.substring(qtPos+1, dblQtPos));
        if(inches < 0 || inches > 11 || feet < 0) {
            return -1;
        }
        return (feet*12 + inches == 0) ? -1 : feet * 12 + inches;
        /*String nums = "0123456789";
        value = value.toLowerCase();
        int val = 0;
        String build = " ";
        for(int i = 0; i < value.length(); i++) {
            if(nums.indexOf(value.charAt(i)) != -1) {
                build += value.charAt(i);
            }
        }
        //
        return Integer.parseInt(build);*/
    }

    /**
     * main uses a scanner to prompt the user for their height and weight and then it converts it to their BMI by calling other methods
     * @param args command line arguments, as needed
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        int inches, weight;
        while(true) {
            /*try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\"): ");
                inches = extractInches(in.nextLine());
                System.out.print("Enter your weight in pounds: ");
                weight = in.nextInt();
                //in.nextLine();
                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, weight)) + " kg/m^2");
                // print user's BMI
                in.nextLine();
            } catch (Exception e) {
                System.out.println("please enter correct height and weight ");
                continue;}*/

            System.out.print("Enter your height in feet and inches (Ex 6'1\"): ");
            inches = extractInches(in.nextLine());
            System.out.print("Enter your weight in pounds: ");
            weight = in.nextInt();
            //in.nextLine();
            //System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, weight)) + " kg/m^2");
            // print user's BMI
            if(!df.format(computeBMI(inches, weight)).equals("0.00"))
                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, weight)) + " kg/m^2 ");
            else System.out.println("Please enter valid weight and height");
            in.nextLine();
            System.out.print("Continue? Y/N: ");
            String cont = in.nextLine();
            if(!cont.toLowerCase().equals("y"))
                break;


        }
        System.out.println("End of program");
    }
}
