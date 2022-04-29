/**
 * this is the Waypoint class
 * @author molliedoyle
 * @version 04/29/22
 */

public class Waypoint   { //implements Comparable<Waypoint>{
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    /**
     * accessor method that returns the waypoint's parameters
     * @param t
     * @param n
     * @param s
     * @param ts
     * @param tk
     * @param e
     */
    public Waypoint(String t, String n, String s, double ts, double tk, int e){
        type = t;
        name = n;
        state = s;
        toSpringer = ts;
        toKatahdin = tk;
        elevation = e;
    }
    /**
     * default constructor
     */
    public Waypoint() {
        type = "";
        name = "";
        state = "";
        toSpringer = 0;
        toKatahdin = 0;
        elevation = 0;
    }

    /**
     * accessor method that returns the waypoint's elevation
     * @return elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * accessor method that returns the waypoint's distance to Katahdin
     * @return toKatahdin
     */
    public double getToKatahdin() {
        return toKatahdin;
    }

    /**
     * accessor method that returns the waypoint's distance to Springer
     * @return toSpringer
     */
    public double getToSpringer() {
        return toSpringer;
    }

    /**
     * accessor method that returns the waypoint's state
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * accessor method that returns the waypoint's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * accessor method that returns the waypoint's type
     * @return type
     */
    public String getType() {
        return type;
    }

    @Override
    /**
     * the toString method makes the data into strings
     */
    public String toString() {
        return "Waypoint{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", toSpringer=" + toSpringer +
                ", toKatahdin=" + toKatahdin +
                ", elevation=" + elevation +
                '}';
    }

    //public int compareTo(Waypoint other) {
        //return (this.elevation - other.elevation)*-1;
        //return this.name.compareTo(other.name)*-1;
       // Double d1 = one.toKatahdin;
       // Double d2 = tw.toKatahdin;

    //}

}
