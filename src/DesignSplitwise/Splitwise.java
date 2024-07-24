package DesignSplitwise;

import DesignSplitwise.Expense.ExpenseSplitType;
import DesignSplitwise.Expense.Split.Split;
import DesignSplitwise.Group.Group;
import DesignSplitwise.Group.GroupController;
import DesignSplitwise.User.User;
import DesignSplitwise.User.UserController;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    public Splitwise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }
    public void demp(){
        setUpUserAndGroup();
        Group group = groupController.getGroup(1);
        group.addMember(userController.getUser(3));
        group.addMember(userController.getUser(2));
        List<Split> splitList = new ArrayList<>();
        Split split1 = new Split(300,userController.getUser(3));
        Split split2 = new Split(300,userController.getUser(2));
        Split split3 = new Split(300,userController.getUser(1));
        splitList.add(split1);
        splitList.add(split2);
        splitList.add(split3);
        group.createExpense(1,"Breakfast",900.0,splitList, ExpenseSplitType.EQUAL,userController.getUser(1));
        List<Split> splitList2 = new ArrayList<>();
        Split split4 = new Split(400,userController.getUser(1));
        Split split5 = new Split(100,userController.getUser(2));
        splitList2.add(split4);
        splitList2.add(split5);
        group.createExpense(2,"Lunch",500,splitList2,ExpenseSplitType.UNEQUAL,userController.getUser(2));
        for(User user : userController.getUserList()){
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }
    public void setUpUserAndGroup(){
        addUsersToSplitwiseApp();
        User user1 = userController.getUser(1);
        groupController.createNewGroup(1,"New Group",user1);
    }
    public void addUsersToSplitwiseApp(){
        User user1 = new User(1,"User1");
        User user2 = new User(2,"User2");
        User user3 = new User(3,"User3");
        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }
}
