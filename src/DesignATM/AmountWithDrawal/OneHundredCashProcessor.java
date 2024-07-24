package DesignATM.AmountWithDrawal;

import DesignATM.ATM;

public class OneHundredCashProcessor extends CashWithdrawProcesser{
    public OneHundredCashProcessor(CashWithdrawProcesser nextProcesser) {
        super(nextProcesser);
    }
    public void withdrawCash(ATM atm, int remainingAmount) {
        int required = remainingAmount / 100;
        int balance = remainingAmount % 100;

        if(required <= atm.getNoOfOneHundredNotes()){
            atm.deductOneHundredNotes(required);
        }
        else if(required > atm.getNoOfOneHundredNotes()){
            balance = remainingAmount - (atm.getNoOfOneHundredNotes() * 100);
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
        }
        if(balance != 0){
            super.withdrawCash(atm,balance);
        }
    }
}
