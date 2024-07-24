package PaymentGateway.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<User> userList = new ArrayList<>();

    User addUser(User user){
        userList.add(user);
        return user;
    }

    User getUser(int userId){
        for (User user: userList){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }

}
