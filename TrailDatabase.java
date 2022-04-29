/**
 * this is the TrailDatabase class
 * @author molliedoyle
 * @version 04/29/22
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Collections;
import java.io.*;

public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private int searchTerm;
    private boolean asc;

    /**
     * TrailDatabase creates an ArrayList, database
     */
    public TrailDatabase() {
        database = new ArrayList<>();
        populateDatabase();
        //database.add(new Waypoint("FEATURE", "Springer Mt (3782 ft", "GA", 0, 2174.6, 3782));
        //database.add(new Waypoint("FEATURE", "Clingmans Dome (6643 ft)", "TN", 195.3, 1979.3, 6643));
        //database.add(new Waypoint("FEATURE", "Mt Katahdin (5268 ft)", "ME", 2174.6, 0, 5268));
    }

    /**
     * getSearchTerm prompts the user and reads the input
     */
    public void getSearchTerm() {
        System.out.println("+ Menu of search terms to use for sorting waypoints +\n" + "\tTY: by type\n" + "\tNA: by name\n" + "\tDS: by distance to Springer\n" + "\tDK: by distance to Katahdin\n" + "\tEL: by elevation\n");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        if(term.equals("TY"))
            searchTerm = 1;
        else if(term.equals("NA"))
            searchTerm = 2;
        else if(term.equals("ST"))
            searchTerm = 3;
        else if(term.equals("DS"))
            searchTerm = 4;
        else if(term.equals("DK"))
            searchTerm = 5;
        else if(term.equals("EL"))
            searchTerm = 6;
        else
            searchTerm = 0;
        if(searchTerm != 0) {
            System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            term = in.nextLine();
            asc = (term.toLowerCase().equals("A")) ? true : false;
        }
        //DOES THIS PART WORK? 9:05
    }

    /**
     * printDatabase prints the database
     */
    public void printDatabase() {
        for(Waypoint w : database)
            System.out.println(w);
    }

    /**
     * sortDB sorts the database using MergeSort
     */
    public void sortDB() {
        MergeSort.sort(database, new WaypointComparator(searchTerm, asc));
       // Collections.sort(database, new WaypointComparator(6, false));
    }

    /**
     * populateDatabase gets the file and parses it
     */
    public void populateDatabase() {
        try{
            Scanner in = new Scanner(new File("apptrailDB.txt"));
            while(in.hasNext()) {
                String[] line = in.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]), Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**private void selectionSort() {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc);
        Waypoint toSwap;
        int index;
        for(int out = 0; out < database.size(); out++) {
            index = out;
            toSwap = database.get(out);
            //Waypoint PIVOT = database.get(0);
            for(int in = out+1; in < database.size(); in++) {
                Waypoint temp = database.get(in);
                if(wc.compare(temp, toSwap) < 0) {
                    toSwap = new Waypoint(temp);
                    index = in;
                }
            }
            database.set(index, database.get(out));
            database.set(out, toSwap);
        }
    }**/
    /**
     * this is the main method for TrailDatabase
     * @param args argument command line
     */
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***");
        while(true) {
            db.getSearchTerm();
            if(db.searchTerm == 0)
                break;
            db.sortDB();
            db.printDatabase();
        }

    }
}
