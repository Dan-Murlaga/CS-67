import java.util.ArrayList;

public class PolymorphismDriver {

    public static void main(String[] args) {
        // An ArrayList of the superclass type holding different subclass objects.
        // Each object is a single purchase, so each carries its own amount.
        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(new CreditCardPayment("4111111111111111", 25.00, 500.00, 12, 2028));
        payments.add(new CreditCardPayment("5555555555554444", 750.00, 500.00, 12, 2028));  // over the limit
        payments.add(new CreditCardPayment("378282246310005", 15.00, 1000.00, 3, 2024));    // expired
        payments.add(new PayPalPayment("jordan@example.com", 42.50));
        payments.add(new ApplePayPayment("DAN-5567", 9.99));
        payments.add(new VenmoPayment("danmurlaga", 19.99));

        // p is declared as a Payment, but the correct subclass's
        // processPayment method is chosen at runtime.
        for (Payment p : payments) {
            p.processPayment();
            p.printReceipt();
        }
    }
}
