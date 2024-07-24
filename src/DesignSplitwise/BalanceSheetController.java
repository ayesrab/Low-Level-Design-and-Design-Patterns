package DesignSplitwise;

import DesignSplitwise.Expense.Split.Split;
import DesignSplitwise.User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserBalanceSheet(User expensePaidBy, List<Split> splitList, double totalExpenseAmount) {
        UserBalanceSheet paidByUserBalanceSheet = expensePaidBy.getUserBalanceSheet();
        paidByUserBalanceSheet.setTotalPayment(totalExpenseAmount);

        for (Split split : splitList) {
            User userOwe = split.getUser();
            UserBalanceSheet userOweBalanceSheet = userOwe.getUserBalanceSheet();
            double oweAmount = split.getAmountOwe();
            if(expensePaidBy.getUserId() == userOwe.getUserId()) {
                paidByUserBalanceSheet.setTotalExpense(paidByUserBalanceSheet.getTotalExpense() + oweAmount);
            }
            else {
                // update the balanceSheet of paidByUser
                paidByUserBalanceSheet.setTotalYouGetBack(paidByUserBalanceSheet.getTotalYouGetBack() + oweAmount);
                Balance userOweBalance;
                if(paidByUserBalanceSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {
                    userOweBalance = paidByUserBalanceSheet.getUserVsBalance().get(userOwe.getUserId());
                }
                else{
                    userOweBalance = new Balance();
                    paidByUserBalanceSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);
                // update the balanceSheet of oweUser
                userOweBalanceSheet.setTotalYouOwe(userOweBalanceSheet.getTotalYouOwe() + oweAmount);
                userOweBalanceSheet.setTotalExpense(userOweBalanceSheet.getTotalExpense() + oweAmount);
                Balance userPaidBalance;
                if(userOweBalanceSheet.getUserVsBalance().containsKey(expensePaidBy.getUserId())){
                    userPaidBalance = userOweBalanceSheet.getUserVsBalance().get(expensePaidBy.getUserId());
                }
                else {
                    userPaidBalance = new Balance();
                    userOweBalanceSheet.getUserVsBalance().put(expensePaidBy.getUserId(), userOweBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }
    }
    public void showBalanceSheetOfUser(User user){
        System.out.println("---------------------------------------");
        System.out.println("Balance sheet of user : " + user.getUserId());
        UserBalanceSheet userBalanceSheet = user.getUserBalanceSheet();
        System.out.println("TotalYourExpense: " + userBalanceSheet.getTotalExpense());
        System.out.println("TotalGetBack: " + userBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymnetMade: " + userBalanceSheet.getTotalPayment());
        for(Map.Entry<Integer,Balance> entry : userBalanceSheet.getUserVsBalance().entrySet()){
            Integer userId = entry.getKey();
            Balance balance = entry.getValue();
            System.out.println("userID:" + userId + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }
        System.out.println("---------------------------------------");
    }

}
