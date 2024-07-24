package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.Card;

public class HasCardState extends ATMState{
    @Override
    public void authenticatePin(ATM atm, Card card, int pin){
        if(card.isCorrectPINEntered(pin)){
            System.out.println("Authentication successful");
            atm.setCurrentATMState(new SelectOperationState());
        }
        else{
            System.out.println("Authentication failed");
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

}
