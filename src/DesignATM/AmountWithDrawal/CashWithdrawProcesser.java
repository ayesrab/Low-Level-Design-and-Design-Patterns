package DesignATM.AmountWithDrawal;

import DesignATM.ATM;

public abstract class CashWithdrawProcesser {
    CashWithdrawProcesser nextProcesser;

    public CashWithdrawProcesser(CashWithdrawProcesser nextProcesser) {
        this.nextProcesser = nextProcesser;
    }

    public void withdrawCash(ATM atm, int remainingAmount) {
        if (nextProcesser != null) {
            nextProcesser.withdrawCash(atm, remainingAmount);
        }
    }
}
