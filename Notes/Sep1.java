package Notes;
import java.util.Scanner;

public class Sep1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int amountOfPeople;
        Double totalCost, costPlusTip;

        System.out.println("Please enter the number of people:");
        amountOfPeople = keyboard.nextInt();

        System.out.println("Please enter the total of the bill:");
        totalCost = keyboard.nextDouble();
        keyboard.close();

        costPlusTip = totalCost * 1.15;
        System.out.println("With a 15% tip, the total bill is " + costPlusTip);
        System.out.println("Each person owes $" + costPlusTip/amountOfPeople);
    }
}