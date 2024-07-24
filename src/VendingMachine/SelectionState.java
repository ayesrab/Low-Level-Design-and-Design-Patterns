package VendingMachine;

import java.util.List;

public class SelectionState implements State {
    public SelectionState() {
        System.out.println("Currently Vending machine is in Selection State");
    }

    @Override
    public void clickOnInsertButton(VendingMachine machine) throws Exception {
        throw new Exception("you can not click on insert coin button in Selection state");
    }

    @Override
    public void insertCoin(Coin coin,VendingMachine machine) throws Exception {
        throw new Exception("you can not insert Coin in selection state");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        //1. get item of this codeNumber
        Item item = machine.getInventory().getItem(codeNumber);

        int paidByUser = 0;
        //2. total amount paid by User
        List<Coin> coinList = machine.getCoinList();
        for (Coin coin : coinList) {
            paidByUser += coin.value;
        }
        //3. compare product price and amount paid by user
        if(paidByUser < item.getPrice()){
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(machine);
            throw new Exception("insufficient amount");
        }
        else {
            getChange(paidByUser - item.getPrice());
            machine.setState(new DispenseState(machine,codeNumber));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        //actual logic should be to return COINs in the dispense tray, but for simplicity i am just returning the amount to be refunded
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed Selection state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");

    }
}
