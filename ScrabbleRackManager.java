import java.util.*;
import java.io.*;
/**
 * ScrabbleRackManager shows all of the playable options from a set of letters
 * @version 03/25/2022
 * @author molliedoyle
 */
public class ScrabbleRackManager<tiles> {

    ArrayList<ArrayList<String>> dictionary;
    ArrayList<String> tileRack;
    ArrayList<String> tiles = new ArrayList<>();
    private final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String[] letters = {"A", "A", "A", "A", "A", "A", "A", "A", "A", "B", "B", "C", "C", "D", "D", "D", "D", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "F", "F", "G", "G", "G", "H", "H", "I", "I", "I", "I", "I", "I", "I", "I", "I", "J", "K", "L", "L", "L", "L", "M", "M", "N", "N", "N", "N", "N", "N", "N", "O", "O", "O", "O", "O", "O", "O", "O", "P", "P", "Q", "R", "R", "R", "R", "R", "R", "S", "S", "S", "S", "T", "T", "T", "T", "T", "T", "U", "U", "U", "U", "V", "V", "W", "W", "X", "Y", "Y", "Z"};


    /** class constructor*/
    public ScrabbleRackManager(){
        dictionary = new ArrayList<>();
        for(int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
        buildTileRack();
    }
    private void buildTileRack() {
        tileRack = new ArrayList<>();
        ArrayList<String> tiles = new ArrayList<>();
        for (String s : letters)
            tiles.add(s);
        Collections.shuffle(tiles);
        for (int i = 0; i < 7; i++) {
            tileRack.add(tiles.remove((int)(Math.random() * tiles.size())));
            //tileRack = new ArrayList<String>();
            //String alpha = "abcdefghijklmnopqrstuvwxyz";
            //int[] frequencies = {9, 2, 2, 4, 12, 2,};
            //buildTileRack();
        }
    }
        /**
         * populateDictionary creates a scanner that calls in a file to test
         */
        public void populateDictionary() {
            try {
                Scanner in = new Scanner(new File("SCRABBLE.txt"));
                while (in.hasNext()) {
                    String word = in.nextLine();
                    dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
                }
                in.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    /** displays the contents of the player's tile rack */
    public void printRack() {
        System.out.println("Letters in the rack: " + tileRack);
        //buildTileRack();
    }

    /** builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile
     * rack */
    public ArrayList<String> getPlaylist() {
        ArrayList<String> plays = new ArrayList<>();
      //  for(bucket : dictionary)
        //this is iterating through every bucket in dictionary
        for(ArrayList<String> bucket : dictionary)
            //if the first letter of the first word in each bucket is not in the tile rack then I don't need to look at all the words in that individual bucket
            if(tileRack.indexOf(bucket.get(0).substring(0,1)) != -1) {
                for(String word : bucket) {
                    if(isPlayable(word))
                        plays.add(word);
                }
            }
        return plays;
    }

    /** print all of the playable words based on the letters in the tile rack */
    public void printMatches() {
        //ArrayList<String> plays = getPlaylist()
        //for(String word :
        //System.out.println(getPlaylist());
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack: ");
        if(plays.size() == 0)
            System.out.println("Sorry, NO words can be played from those tiles. ");
        for(int i = 0; i < getPlaylist().size(); i++) {
            String word = plays.get(i);
            if(word.length() == 7) {
                word += "*";
                bingo = true;
            }
            System.out.printf(String.format("%-10s", word));
            if((i+1) % 10 == 0)
                System.out.println();
        }
        if(bingo)
            System.out.println("\n* Denotes BINGO");
    }

    private boolean isPlayable(String word) {

        ArrayList<String> copy = new ArrayList<>(tileRack);
        for (int i = 0; i < word.length(); i++) {
            if (!copy.remove(word.substring(i, i + 1)))
                return false;
        }
        return true;
    }

    /** main method for the class; use only 3 command lines in main*/
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();

}

    //private final String alpha = "abcdefghijklmnopqrstuvwxyz";
    //ArrayList<String> tiles;
   // ArrayList<String> tileRack;
    //ArrayList<ArrayList<String>> dictionary;
}
