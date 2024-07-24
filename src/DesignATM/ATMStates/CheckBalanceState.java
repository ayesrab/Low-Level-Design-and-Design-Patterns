package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.Card;
import DesignATM.TransactionType;

public class CheckBalanceState extends ATMState{

    public void displayBalance(ATM atm, Card card){
        System.out.println("Your Balance is: " + card.getBankBalance());
        exit(atm);
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
