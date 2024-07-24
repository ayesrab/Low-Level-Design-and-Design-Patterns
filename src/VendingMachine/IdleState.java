package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {
    public IdleState() {
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently Vending machine is in IdleState");
        machine.setCoinList(new ArrayList<Coin>());
    }

    @Override
    public void clickOnInsertButton(VendingMachine machine) throws Exception {
        machine.setState(new HasMoneyState());
    }

    @Override
    public void insertCoin(Coin coin, VendingMachine machine) throws Exception {
        throw new Exception("You cannot insert coins in Idle State");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        throw new Exception("first you need to click on insert coin button");
    }

    @Override
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You cannot select product in Idle State");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("you can not get refunded in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(codeNumber,item);
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed idle state");
    }
}
