import java.util.*;
import java.io.*;

/**
 * SubWordFinder takes user input and determines if the input can be split into subwords
 * @author molliedoyle
 * @version 02/01/2022
 */

public class SubWordFinder implements WordFinder{
    private ArrayList<ArrayList<String>> dictionary; // jagged list
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * SubWordFinder creates an array list, dictionary
     */
    public SubWordFinder() {
        dictionary = new ArrayList<>();
        for(int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * populateDictionary creates a scanner that calls in a file to test
     */
    public void populateDictionary() {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));

            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    private int indexOf(String word) {
       int low = 0;
       ArrayList<String> bucket = dictionary.get(alpha.indexOf(word.charAt(0)));
       int high = bucket.size()-1;
       while(low <= high) {
           int mid = (low + high) / 2;
           if (bucket.get(mid).compareTo(word)==0)
               return mid;
           else if (bucket.get(mid).compareTo(word)<0)
               low = mid + 1;
           else
               high = mid - 1;
           //return mid;
       }
       return -1;
    }

    /**
     * inDictionary searches for a word in the dictionary
     * @param word The item to be searched for in dictionary
     * @return indexOf
     */
    @Override
    public boolean inDictionary(String word) {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(word) >= 0;
        //return Collections.binarySearch(bucket, word) > 0;
    }

    /**
     * getSubWords searches for subwords within the dictionary
     * @return subwords
     */
    @Override
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subwords = new ArrayList<>();
        for (ArrayList<String> bucket : dictionary) {
            for (String word : bucket) {
                for (int i = 3; i < word.length() - 2; i++) {
                    String sub1 = word.substring(0, i);
                    String sub2 = word.substring(i);
                    if(inDictionary(sub1) & inDictionary(sub2)) {
                        SubWord subword = new SubWord(word, sub1, sub2);
                        subwords.add(subword);
                    }
                }
            }
        }
        return subwords;
    }

    /**
     * printDictionary prints out all of the words in the dictionary
     */
    public void printDictionary() {
        for(ArrayList<String> bucket : dictionary)
            System.out.println(bucket);
        int MAXLEN = dictionary.get(0).size();
        int MAXINDEX = 0;
        for(int i = 1; i < dictionary.size(); i++) {
            if(dictionary.get(i).size() > MAXLEN) {
                MAXLEN = dictionary.get(i).size();
                MAXINDEX = i;
            }
        }
        System.out.println("The longest sublist is at index " + MAXINDEX + " starting with " + "the letter " + alpha.charAt(MAXINDEX));
    }

    /**
     * the main method for SubWordFinder
     * @param args command line arguments, as needed
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        ArrayList<SubWord> subs = app.getSubWords();
        for(SubWord word : subs)
            System.out.println(word);
        //ArrayList<SubWord> subword = new Arraylist<>();
        //for(subword temp : subs)
        //System.out.println("# = " + subs.size());
    }

}
