public abstract class Coin {
    /**
     * getValue gets a value when it's called
     */
    public abstract double getValue();

    /**
     * getName get the name of the coin when needed
     * @return null
     */
    public String getName() {
        return null;
    }

    /**
     * getPluralName returns the plural name of the coin
     * @return the plural name
     */
    public String getPluralName() {
        if(getName().equals("penny"))
            return "pennies";
        else
            return getName() + "s";
    }


}
