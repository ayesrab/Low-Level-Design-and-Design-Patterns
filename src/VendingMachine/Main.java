package VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        try{
            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(machine);
            displayInventory(machine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingMachineState = machine.getState();
            vendingMachineState.clickOnInsertButton(machine);

            vendingMachineState = machine.getState();
            vendingMachineState.insertCoin(Coin.PENNY,machine);
            //vendingMachineState.insertCoin(Coin.QUARTER,machine);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingMachineState.clickOnSelectProductButton(machine);

            vendingMachineState = machine.getState();
            vendingMachineState.selectProduct(machine,105);

            displayInventory(machine);

        }catch (Exception e){
            displayInventory(machine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setItemType(ItemType.WATER);
                newItem.setPrice(12);
            }else if(i >=3 && i<5){
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i >=5 && i<7){
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    public static void displayInventory(VendingMachine machine){
        ItemShelf[] slots = machine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItem().getItemType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }

    }
}
