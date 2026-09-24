public class ApplePayPayment extends Payment {
    public ApplePayPayment(String deviceAccountNumber, double amount) {
        super("Apple Pay", deviceAccountNumber, amount);
    }

    @Override
    public void processPayment() {
        System.out.printf("Authorizing $%.2f with Apple Pay account %s%n", getAmount(), getMaskedAccountId());
    }
}
