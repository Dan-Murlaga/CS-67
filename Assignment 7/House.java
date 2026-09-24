/** An unnamed {@link Building} with a square footage. */
public class House extends Building {
    private int squareFeet;

    /**
     * Creates a house.
     *
     * @param address    street address of the house
     * @param capacity   maximum number of people the house can hold
     * @param squareFeet floor area of the house, in square feet
     */
    public House(String address, int capacity, int squareFeet) {
        super(address, capacity);
        this.squareFeet = squareFeet;
    }

    public House(String address, int capacity) {
        super(address, capacity);
        this.squareFeet = 2200; // default square footage for a house
    }

    /** @return a description of the house's address, capacity, and square footage */
    public String toString() {
        String superResult = super.toString().replaceFirst("hold", "house").replaceAll("\\.", "");
        return superResult + " and has %d square feet of space.".formatted(squareFeet);
    }

    /** @return the house's floor area, in square feet */
    public int getSquareFeet() {
        return squareFeet;
    }

    /** @return the literal string "House" */
    public String getName() {
        return "House";
    }
}
