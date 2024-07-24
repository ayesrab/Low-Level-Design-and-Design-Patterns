package DesignSplitwise.Expense.Split;

import java.util.List;

public class UnequalExpenseSplit implements ExpenseSplit{
    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        double getTotal = 0;
        for (Split split : splitList) {
            getTotal += split.getAmountOwe();
        }
        if(getTotal != totalAmount){
            // throw exception
        }
    }
}
