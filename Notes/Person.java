package Notes;

public class Person {
    String name;
    Date birthday;

    public Person(String n, Date bday) {
        name = n;
        birthday = bday;
    }

    public String toString() {
        return name + ", " + birthday;
    }
}
