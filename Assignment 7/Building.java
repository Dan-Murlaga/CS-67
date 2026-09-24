/** Base class for a building with an address and person capacity. */
public abstract class Building {
    private String address;
    private int capacity;
    private String name;

    /**
     * Creates an unnamed building.
     *
     * @param address  street address of the building
     * @param capacity maximum number of people the building can hold
     */
    public Building(String address, int capacity) {
        this.address = address;
        this.capacity = capacity;
        name = null;
    }

    /**
     * Creates a named building.
     *
     * @param name     name of the building
     * @param address  street address of the building
     * @param capacity maximum number of people the building can hold
     */
    public Building(String name, String address, int capacity) {
        this.address = address;
        this.capacity = capacity;
        this.name = name;
    }
    
    /** @return a description of the building's name, address, and capacity */
    public String toString() {
        return "%s at %s can hold up to %d people.".formatted(getName(), address, capacity);
    }

    /** @return the building's street address */
    public String getAddress() {
        return address;
    }

    /** @return the maximum number of people the building can hold */
    public int getCapacity() {
        return capacity;
    }

    /** @return the building's name */
    public String getName() {
        return name;
    }

    /** @param name new name for the building */
    public void setName(String name) {
        this.name = name;
    }
}
