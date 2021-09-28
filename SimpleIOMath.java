import java.util.Scanner;

/**
 * SimpleIOMath is a conversation between the user and the computer
 * @version Monday, September 27, 2021
 * @author molliedoyle
 */

public class SimpleIOMath {
    private String name;
    private int age;
    private int newAge;
    private int oldAge;
    private int favNumber;

    private int smallestPrime(int num) {
        for(int i = 2; i<= (int)(Math.sqrt(num))+1; i++) {
            if(num % i == 0)
                return i;
        }
        return num;
    }

    /**
     * this method prompts the user with a series of questions
     */
    public void promptUser() {
        Scanner in = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        name = in.nextLine();
        System.out.print("Question 2: How old are you? ");
        age = Integer.parseInt(in.nextLine());

        System.out.print("Question 3: What is your favorite number? ");
        favNumber = Integer.parseInt(in.nextLine());

    }

    /**
     * this method takes the user input and prints it back out with other output
     */
    public void printInfo() {
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        newAge = ++age;
        System.out.println("At your next birthday, you will turn " + newAge + ".");
        oldAge = --age;
        System.out.println("The first prime factor of " + oldAge + " is: " + smallestPrime(oldAge));
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + favNumber*favNumber);

    }

    /**
     * this method is for the extra in my lab, it takes the users favorite number and finds the square root.
     */
    public void myExtra() {
        System.out.println("The square root of your favorite number is: " + Math.sqrt(favNumber));
    }

    /**
     * main entry point for class SimpleIOMath
     * @param args command line arguments, as needed
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        System.out.println("I'm gonna teach you how to sing it out\n" +
                "Come on, come on, come on\n" +
                "Let me tell you what it's all about\n" +
                "Reading, writing, arithmetic\n" +
                "Are the branches of the learning tree");
        obj.printInfo();
        obj.myExtra();
        System.out.println("* end of program *");
    }
}
