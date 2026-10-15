/**
 * A class that can be serialized.
 */

import java.io.Serializable;

public class MyClass implements Serializable {
    private int number;

    public MyClass(int n) {
        number = n;
    }

    public String toString() {
        return "The number is " + number;
    }

}


