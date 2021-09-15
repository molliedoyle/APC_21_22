import java.util.Scanner;

/**
 * HolyGrail is a conversation between the computer and user.
 * @version 09/15/2021
 * @author molliedoyle
 */


public class HolyGrail {
    /**
     * main entry point for class HolyGrail
     * @param args command line arguments, as needed
     */
    public static void main(String[] args) {
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
        // program welcomes the user to the program
        Scanner input = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        // program asks for users name
        String name = input.nextLine();
        System.out.print("Question 2: What is your quest? ");
        // program asks for users quest
        String quest = input.nextLine();
        System.out.print("Question 3: What is your favorite color? ");
        // program asks for users favorite color
        String color = input.nextLine();
        System.out.println("King Arthur says, \"You have to know these things when you're a king, you know.\"");
        System.out.println("Your name is: " + name);
        System.out.println("Your quest is: " + quest);
        System.out.println("Your favorite color is " + color);
        System.out.println("* end of program *");
        // program restates users input and says end of program
    }
}
