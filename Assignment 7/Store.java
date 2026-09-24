/** A {@link Building} that sells a particular kind of goods. */
public class Store extends Building {
    private String kind;

    /**
     * Creates a store.
     *
     * @param name     name of the store
     * @param address  street address of the store
     * @param capacity maximum number of people the store can hold
     * @param kind     category of goods the store sells (e.g. "Hardware")
     */
    public Store(String name, String address, int capacity, String kind) {
        super(name, address, capacity);
        this.kind = kind;
    }

    /** @return a description of the store's name, address, capacity, and kind */
    public String toString() {
        String superResult = super.toString().replaceAll("\\.", "");
        return superResult + " and is a %s store.".formatted(kind.toLowerCase());
    }

    /** @return the category of goods the store sells */
    public String getKind() {
        return kind;
    }

    /** @param kind new category of goods the store sells */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Rebrands this store to match another store's name and kind, e.g. converting one
     * chain's location into another's.
     *
     * @param otherStore store whose name and kind this store should adopt
     */
    public void changeInto(Store otherStore) {
        setKind(otherStore.getKind());
        setName(otherStore.getName());
    }
}
