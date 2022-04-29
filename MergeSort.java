/**
 * This is the MergeSort class
 * @author molliedoyle
 * @version 04/29/22
 */

import java.util.ArrayList;

/**
 * This is the MergeSort class that is implemented in TrailDatabase
 */
public class MergeSort {
    private static ArrayList<Waypoint> temp;
    private static WaypointComparator wc;

    /**
     * This method sorts using recursiveSort
     * @param a
     * @param w
     */
    public static void sort(ArrayList<Waypoint> a, WaypointComparator w)   {
        wc = w;
        int n = a.size();
        temp = new ArrayList<>(n);
        for(int i = 0; i < a.size(); i++)
            temp.add(new Waypoint());
        recursiveSort(a, 0, n-1);
    }

    private static void recursiveSort(ArrayList<Waypoint> a, int from, int to)   {
        if(to - from < 2)   {
            if(to > from && wc.compare(a.get(to), a.get(from)) < 0)   { //COMPARATOR
                Waypoint aTemp = a.get(to);
                a.set(to, a.get(from));
                a.set(from, aTemp);
            }
        }
        else {
            int middle = (from + to)/2;
            recursiveSort(a, from, middle);
            recursiveSort(a, middle+1, to);
            merge(a, from, middle, to);
        }
    }

    private static void merge(ArrayList<Waypoint> a, int from, int middle, int to)   {
        int i = from, j = middle + 1, k = from;
        while(i <= middle && j <= to)   {
            if(wc.compare(a.get(i), a.get(j)) < 0)    { //COMPARATOR
                temp.set(k, a.get(i));
                i++;
            }
            else {
                temp.set(k, a.get(j));
                j++;
            }
            k++;
        }
        while(i <= middle)  {
            temp.set(k, a.get(i));
            i++;
            k++;
        }
        while(j <= to)  {
            temp.set(k, a.get(j));
            j++;
            k++;
        }

        for(k = from; k <= to; k++)
            a.set(k, temp.get(k));
    }
}
