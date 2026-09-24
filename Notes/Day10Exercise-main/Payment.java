// A Payment is one purchase: a specific amount paid from a specific account.
public abstract class Payment {
    private String methodName;
    private String accountId;
    private double amount;

    public Payment(String methodName, String accountId, double amount) {
        this.methodName = methodName;
        this.accountId = accountId;
        this.amount = amount;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }

    // Shows only the last 4 characters, e.g. "****1111".
    public String getMaskedAccountId() {
        int visible = Math.min(4, accountId.length());
        return "****" + accountId.substring(accountId.length() - visible);
    }

    // Subclasses inherit this; a subclass can also override it.
    public void printReceipt() {
        System.out.printf("  Receipt: $%.2f paid with %s (account %s)%n",
                amount, methodName, getMaskedAccountId());
    }

    // No body here: each subclass must override this.
    public abstract void processPayment();
}
