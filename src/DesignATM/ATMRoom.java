package DesignATM;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String [] args){
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm,atmRoom.user.getCard());
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm,atmRoom.user.getCard(),112211);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm,atmRoom.user.getCard(),TransactionType.CASH_WITHDRAWAL);
        //atmRoom.atm.getCurrentATMState().displayBalance(atmRoom.atm,atmRoom.user.getCard());
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm,atmRoom.user.getCard(),1200);
        atmRoom.atm.printCurrentATMStatus();
    }

    public void initialize(){
        atm = ATM.getInstance();
        atm.setAtmBalance(3500,1,2,5);
        this.user = createUser();
    }
    public User createUser(){
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    public Card createCard(){
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    public BankAccount createBankAccount(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.balance = 3000;
        return bankAccount;
    }

}
