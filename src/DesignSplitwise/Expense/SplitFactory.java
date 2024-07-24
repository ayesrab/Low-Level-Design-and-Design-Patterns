package DesignSplitwise.Expense;

import DesignSplitwise.Expense.Split.EqualExpenseSplit;
import DesignSplitwise.Expense.Split.ExpenseSplit;
import DesignSplitwise.Expense.Split.PercentageExpenseSplit;
import DesignSplitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType expenseSplitType){
        if(expenseSplitType == ExpenseSplitType.EQUAL){
            return new EqualExpenseSplit();
        }
        else if(expenseSplitType == ExpenseSplitType.UNEQUAL){
            return new UnequalExpenseSplit();
        }
        else if(expenseSplitType == ExpenseSplitType.PERCENTAGE){
            return new PercentageExpenseSplit();
        }
        return null;
    }
}
