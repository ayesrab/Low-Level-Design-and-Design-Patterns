package DesignSplitwise.Group;

import DesignSplitwise.Expense.Expense;
import DesignSplitwise.Expense.ExpenseController;
import DesignSplitwise.Expense.ExpenseSplitType;
import DesignSplitwise.Expense.Split.Split;
import DesignSplitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    int groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group() {
        this.groupMembers = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }
    public void addMember(User user) {
        this.groupMembers.add(user);
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public Expense createExpense(int expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser
    ) {
        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }
}
