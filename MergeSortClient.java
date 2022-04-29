/**
 * This is the MergeSortCLient class
 * @author molliedoyle
 * @version 04/29/22
 */
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortClient {
    /**
     * this the main method for MergeSortClient
     * @param args argument command line
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] nums = {3, 5, 27, 13, 18, -1, 2, 6, 43, -127, 5, 34, 16};
        for(int i : nums)
            list.add(i);
        System.out.println(list);
        //MergeSort.sort(list);
        System.out.println(list);
    }
}
