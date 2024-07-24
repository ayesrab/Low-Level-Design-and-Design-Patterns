package DesignATM;

public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private int holderName;
    static int PIN_NUMBER = 112211;
    private BankAccount bankAccount;

    public boolean isCorrectPINEntered(int pin) {
        return PIN_NUMBER == pin;
    }
    public int getBankBalance(){
        return bankAccount.balance;
    }
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void withdraw(int amount) {
        bankAccount.withdraw(amount);
    }
}
