package DesignSplitwise.Expense;

import DesignSplitwise.Expense.Split.Split;
import DesignSplitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    int expenseId;
    String description;
    double expenseAmount;
    ExpenseSplitType expenseSplitType;
    User paidByUser;
    List<Split> splits;

    public Expense(int expenseId, String description, double expenseAmount, ExpenseSplitType expenseSplitType, User paidByUser) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.expenseSplitType = expenseSplitType;
        this.paidByUser = paidByUser;
        this.splits = new ArrayList<>();
    }
}
