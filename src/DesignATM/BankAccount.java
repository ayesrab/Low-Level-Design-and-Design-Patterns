package DesignATM;

public class BankAccount {
    int balance;
    public void withdraw(int amount) {
        this.balance -= amount;
        return;
    }
}
