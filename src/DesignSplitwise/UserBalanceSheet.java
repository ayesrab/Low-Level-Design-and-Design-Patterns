package DesignSplitwise;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {
    Map<Integer,Balance> userVsBalance;
    double totalExpense;
    double totalPayment;
    double totalYouOwe;
    double totalYouGetBack;

    public UserBalanceSheet() {
        userVsBalance = new HashMap<>();
        totalExpense = 0.0;
        totalPayment = 0.0;
        totalYouOwe = 0.0;
        totalYouGetBack = 0.0;
    }

    public Map<Integer, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<Integer, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }
}
