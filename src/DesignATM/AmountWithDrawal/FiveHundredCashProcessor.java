package DesignATM.AmountWithDrawal;

import DesignATM.ATM;

public class FiveHundredCashProcessor extends CashWithdrawProcesser{
    public FiveHundredCashProcessor(CashWithdrawProcesser nextProcesser) {
        super(nextProcesser);
    }
    public void withdrawCash(ATM atm, int remainingAmount) {
        int required = remainingAmount / 500;
        int balance = remainingAmount % 500;

        if(required <= atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(required);
        }
        else if(required > atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (required-atm.getNoOfFiveHundredNotes()) * 500;

        }
        if(balance != 0){
            super.withdrawCash(atm,balance);
        }
    }
}
