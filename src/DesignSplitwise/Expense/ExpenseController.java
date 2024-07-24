package DesignSplitwise.Expense;

import DesignSplitwise.BalanceSheetController;
import DesignSplitwise.Expense.Split.ExpenseSplit;
import DesignSplitwise.Expense.Split.Split;
import DesignSplitwise.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }
    public Expense createExpense(int expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseSplitType expenseSplitType, User paidByUser) {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(expenseSplitType);
        if(expenseSplit == null) {
            return null;
        }
        expenseSplit.validateSplitRequest(splitDetails,expenseAmount);
        Expense expense = new Expense(expenseId,description,expenseAmount,expenseSplitType,paidByUser);
        balanceSheetController.updateUserBalanceSheet(paidByUser, splitDetails, expenseAmount);
        return expense;
    }
}
