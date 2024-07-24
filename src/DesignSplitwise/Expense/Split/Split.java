package DesignSplitwise.Expense.Split;

import DesignSplitwise.User.User;

public class Split {
    User user;
    double amountOwe;

    public Split(double amountOwe, User user) {
        this.amountOwe = amountOwe;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }
}
