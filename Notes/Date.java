package Notes;

public class Date {
    int month, day, year;

    public Date() {
        month = 1;
        day = 1;
        year = 2000;
    }

    public Date(int mon, int d, int y) {
        month = mon;
        day = d;
        year = y;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }
}