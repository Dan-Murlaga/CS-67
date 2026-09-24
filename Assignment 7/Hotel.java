/** A {@link Building} with a floor count, whose name is suffixed with "Hotel". */
public class Hotel extends Building {
    private int floors;

    /**
     * Creates a single-floor hotel.
     *
     * @param name     hotel's base name (before the "Hotel" suffix)
     * @param address  street address of the hotel
     * @param capacity maximum number of people the hotel can hold
     */
    public Hotel(String name, String address, int capacity) {
        super(name, address, capacity);
        floors = 1;
    }

    /**
     * Creates a hotel with the given number of floors.
     *
     * @param name     hotel's base name (before the "Hotel" suffix)
     * @param address  street address of the hotel
     * @param capacity maximum number of people the hotel can hold
     * @param floors   number of floors in the hotel
     */
    public Hotel(String name, String address, int capacity, int floors) {
        super(name, address, capacity);
        this.floors = floors;
    }

    /** @return a description of the hotel's name, address, capacity, and floors */
    public String toString() {
        String superResult = super.toString().replaceAll("\\.", "");
        return superResult + " and has %d floors.".formatted(floors);
    }

    /** @return the number of floors in the hotel */
    public int getFloors() {
        return floors;
    }

    /** @return the hotel's base name with the "Hotel" suffix */
    public String getName() {
        return super.getName() + " Hotel";
    }
}
