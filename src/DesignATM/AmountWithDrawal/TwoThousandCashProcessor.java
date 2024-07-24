package DesignATM.AmountWithDrawal;

import DesignATM.ATM;

public class TwoThousandCashProcessor extends CashWithdrawProcesser{

    public TwoThousandCashProcessor(CashWithdrawProcesser nextCashWithdrawProcesser) {
        super(nextCashWithdrawProcesser);
    }

    public void withdrawCash(ATM atm, int remainingAmount) {
        int required = remainingAmount / 2000;
        int balance = remainingAmount % 2000;

        if(required <= atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(required);
        }
        else if(required > atm.getNoOfTwoThousandNotes()){
            balance = remainingAmount - (atm.getNoOfTwoThousandNotes() * 2000);
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
        }
        if(balance != 0){
            super.withdrawCash(atm,balance);
        }
    }
}
