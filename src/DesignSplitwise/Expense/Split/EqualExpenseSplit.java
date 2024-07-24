package DesignSplitwise.Expense.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit{
    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        double amountPerUser = totalAmount / splitList.size();
        for (Split split : splitList) {
            if(split.getAmountOwe() != amountPerUser){
                // Throw exception
            }
        }
    }
}
