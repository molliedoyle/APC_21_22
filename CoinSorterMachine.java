import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    // initializes coins ArrayList
    int dc = 0; int hdc = 0; int qc = 0; int dct = 0; int nc = 0; int pc = 0;
    double total = 0;
    DecimalFormat df;

    /**
     * CoinSorterMachine creates an ArrayList to store the coins
     */
    public CoinSorterMachine(){
        coins = new ArrayList<>();
        df = new DecimalFormat("$0.00");
    }
    // use one or two Scanner objects, prompting user for the appropriate file // name and importing the data from filename – MUST handle diabolic values!
    /**
     * depositCoins assigns a numerical value to the coins when they are looked at
     */
    public void depositCoins(){
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the name of the data file for coin deposit: ");
            String file = input.nextLine();
            Scanner in = new Scanner(new File(file));
            while(in.hasNext()) {
                int value = (in.nextInt());
                if(value == 100){
                    coins.add(new Dollar());
                    dc++;}
                if(value == 50){
                    coins.add(new HalfDollar());
                    hdc++;}
                if(value == 25){
                    coins.add(new Quarter());
                    qc++;}
                if(value == 10){
                    coins.add(new Dime());
                    dct++;}
                if(value == 5){
                    coins.add(new Nickel());
                    nc++;}
                if(value == 1){
                    coins.add(new Penny());
                    pc++;}

            }
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
// Prints deposit summary using a DecimalFormat object (see output section)

    /**
     * printDepositSummary prints out the number and value of the total coins
     */
    public void printDepositSummary() {
        System.out.println("Summary of deposit: ");
        Coin penny = new Penny();
        Coin nickel = new Nickel();
        Coin dime = new Dime();
        Coin quarter = new Quarter();

        Coin halfdollar = new HalfDollar();
        Coin dollar = new Dollar();

        System.out.println("\t" + pc + " " + ((pc == 1) ? penny.getName() : penny.getPluralName()) + " " + df.format(pc * penny.getValue()));
        //System.out.println();

        System.out.print("\t" + nc + " " + ((nc == 1) ? nickel.getName() : nickel.getPluralName()));
        System.out.println(" " + df.format(nc * nickel.getValue()));

        System.out.print("\t" + dct + " " + ((dct == 1) ? dime.getName() : dime.getPluralName()));
        System.out.println(" " + df.format(dct * dime.getValue()));

        System.out.println("\t" + qc + " " + ((qc == 1) ? quarter.getName() : quarter.getPluralName()) + " " + df.format(qc * quarter.getValue()));

        System.out.println("\t" + hdc + " " + ((hdc == 1) ? halfdollar.getName() : halfdollar.getPluralName()) + " " + df.format(hdc * halfdollar.getValue()));

        System.out.println("\t" + dc + " " + ((dc == 1) ? dollar.getName() : dollar.getPluralName()) + " " + df.format(dc * dollar.getValue()));

        /*if (nc == 1)
            System.out.print(" " + nickel.getName());
        else System.out.print(" " + nickel.getPluralName());
        System.out.println(" " + df.format(nc * nickel.getValue()));

        for (Coin c : coins) {
            if (c.getName().equals("penny")) {
                System.out.print("\t" + pc);

            } else if (c.getName().equals("nickel")) {
                System.out.print("\t" + nc);

            } else if (c.getName().equals("dime")) {
                /*System.out.print("\t" + dct);
                if (dct == 1)
                    System.out.print(" " + c.getName());
                else System.out.print(" " + c.getPluralName());
                System.out.println(" " + df.format(dct * c.getValue()));
            } else if (c.getName().equals("quarter")) {
                /*System.out.print("\t" + qc);
                if (qc == 1)
                    System.out.print(" " + c.getName());
                else System.out.print(" " + c.getPluralName());
                System.out.println(" " + df.format(qc * c.getValue()));
            } else if (c.getName().equals("half dollar")) {
                System.out.print("\t" + hdc);
                if (hdc == 1)
                    System.out.print(" " + c.getName());
                else System.out.print(" " + c.getPluralName());
                System.out.println(" " + df.format(hdc * c.getValue()));
            } else if (c.getName().equals("dollar")) {
                System.out.print("\t" + dc);
                if (dc == 1)
                    System.out.print(" " + c.getName());
                else System.out.print(" " + c.getPluralName());
                System.out.println(" " + df.format(dc * c.getValue()));
            }
        }*/
            System.out.println("TOTAL DEPOSIT: " + df.format(getTotalValue()));



        }
// return the total value of all Coin objects stored in coins as a double
    /**
     * getTotalValue prints out the total value of all of the coins
     */
    public double getTotalValue() {
        double total = 0.;
        for(Coin c : coins)
            total += c.getValue();
        return total;

            //total = (pc * 0.01 + dct * 0.1 + nc * 0.05 + qc * 0.25 + hdc * 0.5 + dc * 1.0);
            //return df.format(total);
            //return total;
        }
    // main method for the class should use these exact three lines of code

    /**
     * this is the main method for CoinSorterMachine
     * @param args command line arguments if needed
     */
    public static void main(String[] args){
    CoinSorterMachine app = new CoinSorterMachine();
    app.depositCoins();
    app.printDepositSummary();
    }
}

