package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.Card;
import DesignATM.TransactionType;

public class SelectOperationState extends ATMState {
    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        switch (txnType){
            case CASH_WITHDRAWAL :
                atm.setCurrentATMState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atm.setCurrentATMState(new CheckBalanceState());
                break;
            default:
                System.out.println("Invalid transaction type");
                exit(atm);
        }
    }
    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exiting ATM");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
    private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.getAllTransationType();
    }

}
