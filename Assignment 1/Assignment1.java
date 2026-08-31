// Resource: https://docs.oracle.com/javase/tutorial/
public class Assignment1 {
    public static void main(String[] args) {
        // Assigns value to "num"
        int num = 7;

        // Determines whether "num" is even or odd
        if (num%2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }

        // Loops "num" number of times, printing out the number of the current loop each time
        for (int i=1; i<=num; i++) {
            System.out.println("Loop " + i + " of " + num);
        }
    }
}