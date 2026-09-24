public class VenmoPayment extends Payment {
    public VenmoPayment(String accountName, double amount) {
        super("Venmo", accountName, amount);
    }

    @Override
    public void processPayment() {
        System.out.printf("Authorizing $%.2f with Venmo account %s%n", getAmount(), getMaskedAccountId());
    }
}