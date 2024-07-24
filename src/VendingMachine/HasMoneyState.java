package VendingMachine;

import java.util.List;

public class HasMoneyState implements State{
    public HasMoneyState() {
        System.out.println("Currently Vending Machine is in HasMoneyState");
    }

    @Override
    public void clickOnInsertButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(Coin coin, VendingMachine machine) throws Exception {
        System.out.println("You have inserted a coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        machine.setState(new SelectionState());
    }

    @Override
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("you need to click on start product selection button first");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in hasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine,Item item, int codeNumber) throws Exception {
        throw new Exception("you can not update inventory in hasMoney  state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        return null;
    }
}
