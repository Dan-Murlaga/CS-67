public class Cafe extends Store {
    private String hoursOpen;

    public Cafe(String name, String address, int capacity, String kind, String hoursOpen) {
        super(name, address, capacity, kind);
        this.hoursOpen = hoursOpen;
    }

    public Cafe(String name, String address, int capacity, String kind) {
        super(name, address, capacity, kind);
        this.hoursOpen = "8:00 AM - 8:00 PM"; // Default hours if not provided
    }

    public String getHoursOpen() {
        return hoursOpen;
    }

    public void setHoursOpen(String hoursOpen) {
        this.hoursOpen = hoursOpen;
    }

    public String toString() {
        return super.toString().replace("store", "cafe") + " Hours open: " + hoursOpen;
    }
}
