import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 * ScrabbleScorer is a class that builds a dictionary, takes user input, and determines valid scrabble words
 *  * @version 1/24/2022
 *  * @author molliedoyle
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10}; //populate this array
    private String alpha;

    /**
     * ScrabbleScorer assigns a score to the words
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();

        }

    /**
     * buildDictionary correctly builds the dictionary and sorts all of the entries using Collections.sort
     */
    public void buildDictionary() {
        // use try/catch
        // use a scanner
        // read data file
        // when file is read into dictionary, close stream
        // call Collections.sort(dictionary);
        try {
            Scanner in = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while (in.hasNext()) {
                dictionary.add(in.nextLine().strip());
            }
            in.close();
            Collections.sort(dictionary);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * isValidWord is a boolean method to find whether the input is contained in the file
     * @param word
     * @return isValidWord
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word)>=0;

    }
    /**
    * getWordScore get the score for the user's word
     * @param word
     * @return sum
    */
    public int getWordScore(String word) {
        int sum = 0;
        for(int i = 0; i < word.length(); i++)
            sum += points[alpha.indexOf(word.charAt(i))];
            return sum;

        //parse word one letter at a time -- for loop + CharAt or substring
        // find the index of each letter
        // add the corresponding score/point value from points to a sum value

    }

    /**
     * the main method for ScrabbleScorer
     * @param args command line arguments, as needed
     */
    public static void main(String[] args) {
        /*int[] n = {1, 4, 6, 8, -10, 12, 19, 20};
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i : n)
            nums.add(i);
        Collections.sort(nums);
        System.out.println(Collections.binarySearch(nums, 210));*/
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);

        try {
            while(true) {
                System.out.print("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if(userWord.equals("0")) {
                    break;}
                else {
                    if(app.isValidWord(userWord.toUpperCase())) {
                        //print out point value here
                        System.out.println(userWord + " = " + app.getWordScore(userWord.toUpperCase()) + " points");
                    }
                else {
                        System.out.println(userWord + " is not a valid word in the dictionary");
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exiting the program thanks for playing");

    }

}
