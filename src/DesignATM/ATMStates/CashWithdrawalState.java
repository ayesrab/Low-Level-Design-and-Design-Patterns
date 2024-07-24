package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.AmountWithDrawal.CashWithdrawProcesser;
import DesignATM.AmountWithDrawal.FiveHundredCashProcessor;
import DesignATM.AmountWithDrawal.OneHundredCashProcessor;
import DesignATM.AmountWithDrawal.TwoThousandCashProcessor;
import DesignATM.Card;

public class CashWithdrawalState extends ATMState {
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmount) {
        System.out.println(atm.getAtmBalance());
        if(atm.getAtmBalance() < withdrawalAmount) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atm);
        }
        else if(card.getBankBalance() < withdrawalAmount) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atm);
        }
        else {
            atm.deductBalance(withdrawalAmount);
            card.withdraw(withdrawalAmount);
            CashWithdrawProcesser cashWithdrawProcesser = new TwoThousandCashProcessor(new FiveHundredCashProcessor(new OneHundredCashProcessor(null)));
            cashWithdrawProcesser.withdrawCash(atm,withdrawalAmount);
            exit(atm);
        }
    }
    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

}
