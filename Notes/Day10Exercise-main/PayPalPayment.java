public class PayPalPayment extends Payment {
    // PayPal accounts are identified by email, which is stored as the account ID.
    public PayPalPayment(String email, double amount) {
        super("PayPal", email, amount);
    }

    public String getEmail() {
        return getAccountId();
    }

    // Showing the last 4 characters doesn't work for an email address,
    // so show the first letter and the domain instead, e.g. "j*****@example.com".
    @Override
    public String getMaskedAccountId() {
        String email = getEmail();
        int at = email.indexOf('@');
        if (at < 1) {
            return super.getMaskedAccountId();   // not a valid email, use the default
        }
        return email.charAt(0) + "*****" + email.substring(at);
    }

    @Override
    public void processPayment() {
        System.out.printf("Sending $%.2f through PayPal account %s%n", getAmount(), getMaskedAccountId());
    }
}
