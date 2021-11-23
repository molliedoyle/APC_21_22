import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;


/**
 * BaseConverter opens a data file, reads, converts numners, prints
 * @version Thursday 11/18/2021
 * @author molliedoyle
 */
public class BaseConverter {
    /**Constructor for class.
     *
     */
    public BaseConverter() {
        System.out.println();
    }

    /**Convert a String num in fromBase to base-10 int.
     * @param num a string value
     * @param fromBase a string value
     * @return it returns the sum of the Int
     */
    public int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0, exp = 0;
        for(int i = num.length()-1; i >= 0; i--) {
            //System.out.print(num.charAt(i)+" ");
            sum += alpha.indexOf("" + num.charAt(i))* Math.pow(base, exp);
            exp++;
        }
        return sum;
    }

    /**Convert a base-10 int to a String number of base toBase.
     * @param num an integer value
     * @param toBase an integer value
     * @return returns toNum, the string value
     */

    public String intToStr(int num, int toBase) {
        String alpha = "0123456789ABCDEF";
        String toNum = "";
        while(num > 0) {
            toNum = alpha.charAt(num % toBase) + toNum;
            num /= toBase;

        }
        if(toNum.equals(""))
            return "0";

        return toNum;
    }
    /**Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
    */
     public void inputConvertPrintWrite() {
        // because it's void it doesn't need to return anything, void means nothing
        // create a Scanner that open values10.dat and print each line to the screen
         Scanner in = null; //null;
         PrintWriter pw = null;
         /**
          * JFileChooser file1 = new JFileChooser(new File("./datafiles"));
          *          int returnValue = file1.showOpenDialog(null);
          *          if (returnValue == JFileChooser.APPROVE_OPTION) {
          *              File selectedFile = file1.getSelectedFile();
          *              System.out.println(selectedFile.getAbsolutePath());
          */

         try {
             in = new Scanner(new File("datafiles/values30.dat"));

             pw = new PrintWriter(new File("datafiles/converted.dat"));
             while(in.hasNext()) {
                 String[] line = in.nextLine().split("\t");
                 int fromBase = Integer.parseInt(line[1]);
                 int toBase = Integer.parseInt(line[2]);
                 if(fromBase < 2 || fromBase > 16) {
                     System.out.println("Invalid input base " + fromBase);
                 }
                 else if(toBase < 2 || toBase > 16) {
                     System.out.println("Invalid output base " + toBase);
                 }
                 else {
                     System.out.println(line[0] + " base " + fromBase + " = " + intToStr(strToInt(line[0], line[1]), toBase) + " base " + toBase);
                    pw.println(line[0] + "\t" + fromBase + "\t" + intToStr(strToInt(line[0], line[1]), toBase) + "\t" + toBase);
                 }
                  //System.out.println();
                  pw.println();

                     //System.out.println(Arrays.toString(line));
                     //pw.println(Arrays.toString(line));
                     //System.out.println();
                 //}
                 // \t - tab
                 //line = {"24A4B56", "13", "6"};
                 // items to test: line[1] and line[2]
                 //for(String val : line)
                     //System.out.print(val + "\t");
                 //System.out.println();
                 //System.out.println(Arrays.toString(line));
                 //System.out.println();

             //in.close(); // MUY IMPORTANTE
            }

         }
         catch(Exception e) {
             e.printStackTrace();
         }
         if(in != null)
             in.close();
         if(pw != null)
             pw.close();

         /**try {
             FileWriter fw = new FileWriter(new File("datafiles/me.txt"));
             fw.write("how");
             fw.write("now");
             fw.write("brown");
             fw.write("cow");
             fw.write();*/

         //}
         //catch (FileNotFoundException e) {
             //e.printStackTrace();

     }



     /** Main method for class BaseConverter. Yours should look just like this!
     * @param args command line arguments, as needed
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();

        }
        /**JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());}
         */
        //System.out.println("test");
        //System.out.println(app.strToInt("21221201", "3"));
        //System.out.println(app.intToStr(5789324, 16));

}
//if toNum is"":
    //return "0"