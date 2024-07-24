package DesignSplitwise.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList;

    public UserController() {
        userList = new ArrayList<>();
    }
    public void addUser(User user) {
        userList.add(user);
    }
    public void removeUser(User user) {
        userList.remove(user);
    }
    public List<User> getUserList() {
        return userList;
    }
    public User getUser(int id) {
        for (User user : userList) {
            if(user.getUserId() == id){
                return user;
            }
        }
        return null;
    }
}
