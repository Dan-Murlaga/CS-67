package Notes;
/**
 * Class Exercise on 10/1/2026
 * update the code to catch the InputMismatchException if the user
 * enters something that is not an int
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Oct1Exercise {
  public static void main (String[] args){
		int value = -1;
        Scanner keyboard = new Scanner(System.in);
        while (value != 5) {
            System.out.print("Please enter the integer 5: ");
            try {
                value = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                keyboard.nextLine();
            }
        }
        System.out.println("you did it!");
        keyboard.close();
	}  
}