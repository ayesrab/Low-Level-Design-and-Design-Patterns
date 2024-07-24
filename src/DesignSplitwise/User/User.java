package DesignSplitwise.User;

import DesignSplitwise.UserBalanceSheet;

public class User {
    int userId;
    String username;
    UserBalanceSheet userBalanceSheet;

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
        this.userBalanceSheet = new UserBalanceSheet();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }

    public void setUserBalanceSheet(UserBalanceSheet userBalanceSheet) {
        this.userBalanceSheet = userBalanceSheet;
    }
}
