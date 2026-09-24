import java.time.YearMonth;

public class CreditCardPayment extends Payment {
    private double creditLimit;
    private int expMonth;
    private int expYear;
    private boolean approved;

    public CreditCardPayment(String cardNumber, double amount, double creditLimit, int expMonth, int expYear) {
        super("Credit Card", cardNumber, amount);
        this.creditLimit = creditLimit;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.approved = false;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    // A card is valid through the end of its expiration month.
    public boolean isExpired() {
        YearMonth expiration = YearMonth.of(expYear, expMonth);
        return YearMonth.now().isAfter(expiration);
    }

    @Override
    public void processPayment() {
        if (isExpired()) {
            System.out.printf("Declined: credit card %s expired %02d/%d%n",
                    getMaskedAccountId(), expMonth, expYear);
            approved = false;
        }
        else if (getAmount() > creditLimit) {
            System.out.printf("Declined: $%.2f exceeds credit limit of $%.2f on card %s%n",
                    getAmount(), creditLimit, getMaskedAccountId());
            approved = false;
        }
        else {
            System.out.printf("Charging $%.2f to credit card %s%n", getAmount(), getMaskedAccountId());
            approved = true;
        }
    }

    // Only print a receipt if the charge went through.
    @Override
    public void printReceipt() {
        if (approved) {
            super.printReceipt();
        }
        else {
            System.out.println("  No receipt: payment was declined");
        }
    }
}
