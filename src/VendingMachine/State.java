package VendingMachine;

import java.util.List;

public interface State {
    public void clickOnInsertButton(VendingMachine machine) throws Exception;
    public void insertCoin(Coin coin, VendingMachine machine) throws Exception;
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception;
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception;
    public int getChange(int returnChangeMoney) throws Exception;
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception;
    public Item dispenseProduct(VendingMachine machine,int codeNumber) throws Exception;
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;
}
