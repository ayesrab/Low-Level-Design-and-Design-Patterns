package VendingMachine;

public class Inventory {
    ItemShelf [] inventory;

    public Inventory(int size) {
        this.inventory = new ItemShelf[size];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory(){
        int startCode = 101;
        for(int i = 0; i < inventory.length; i++){
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setCode(startCode++);
            itemShelf.setSoldOut(true);
            inventory[i] = itemShelf;
        }
    }
    public void addItem(int code, Item item) throws Exception{
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.soldOut){
                itemShelf.setItem(item);
            }
            else {
                throw new Exception("Item already present in Inventory");
            }
        }
    }
    public Item getItem(int code) throws Exception{
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == code){
                if(itemShelf.soldOut){
                    throw new Exception("Item Sold Out");
                }
                else {
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Invalid Item Code");
    }
    public void updateSoldOutItem(int code){
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == code){
                itemShelf.setSoldOut(true);
            }
        }
    }
}
