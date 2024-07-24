package DesignATM;

import DesignATM.ATMStates.ATMState;
import DesignATM.ATMStates.IdleState;

public class ATM {
    private static ATM atm  = new ATM();
    ATMState currentATMState;
    int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    private ATM(){
    }
    public void setCurrentATMState(ATMState currentATMState){
        this.currentATMState = currentATMState;
    }
    public static ATM getInstance(){
        atm.setCurrentATMState(new IdleState());
        return atm;
    }

    public ATMState getCurrentATMState() {
        return currentATMState;
    }
    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }
    public void deductBalance(int amount){
        this.atmBalance -= amount;
    }
    public void deductTwoThousandNotes(int number){
        noOfTwoThousandNotes = noOfTwoThousandNotes -  number;
    }
    public void deductFiveHundredNotes(int number){
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }
    public void deductOneHundredNotes(int number){
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }
    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }

    public int getAtmBalance() {
        return atmBalance;
    }
}
