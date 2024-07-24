package CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {
    List<User> users;
    List<Store> stores;

    public VehicleRentalSystem(List<User> users, List<Store> stores) {
        this.users = users;
        this.stores = stores;
    }

    public Store getStore(Location location){

        //based on location, we will filter out the Store from storeList.
        return stores.get(0);
    }

    //addUsers

    //remove users


    //add stores

    //remove stores


}
