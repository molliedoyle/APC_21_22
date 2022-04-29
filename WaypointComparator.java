/**
 * this is the WaypointComparator class
 * @author molliedoyle
 * @version 04/29/22
 */
import java.util.Comparator;

public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    /**
     * WaypointComparator creates to variable
     * @param c
     * @param a
     */
    public WaypointComparator(int c, boolean a) {
        category = c;
        asc = a;
    }


    /**
     * compare compares all of the elements of waypoint
     * @param one
     * @param two
     * @return
     */

    public int compare(Waypoint one, Waypoint two) {
        int diff = 0;
        if(category == 1)
            diff = one.getType().compareTo(two.getType());
        else if(category == 2)
            diff = one.getName().compareTo(two.getName());
        else if(category == 3)
            diff = one.getState().compareTo(two.getState());
        else if(category == 4) {
            Double d1 = one.getToSpringer();
            Double d2 = one.getToSpringer();
            diff = d1.compareTo(d2);
        }
        else if(category == 5) {
            Double d1 = one.getToKatahdin();
            Double d2 = one.getToKatahdin();
            diff = d1.compareTo(d2);
        }
        else if(category == 6)
            diff = one.getElevation() - two.getElevation();

        return (asc) ? diff : -diff;
    }
}
