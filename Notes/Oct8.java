package Notes;

import java.util.HashMap;
import java.util.Scanner;

public class Oct8 {
    public static void main(String[] args) {
        HashMap<Integer, String> passwords = new HashMap<Integer, String>();
        Scanner keyboard = new Scanner(System.in);

        passwords.put(101, "password123");
        passwords.put(102, "IHeartCS");
        passwords.put(103, "password123");
        System.out.println(passwords);

        System.out.println(passwords.get(102));

        System.out.print("Enter your username: ");
        int username = keyboard.nextInt();
        keyboard.nextLine();

        if (passwords.containsKey(username)) {
            System.out.print("Enter your password: ");
            String password = keyboard.nextLine();

            if (passwords.get(username).equals(password)) {
                System.out.println("SUCCESS!");
            } else {
                System.out.println("FAILURE!");
            }
        } else {
            System.out.println("FAILURE!");
        }

        keyboard.close();

        passwords.remove(103);
        System.out.println(passwords);
    }
}
