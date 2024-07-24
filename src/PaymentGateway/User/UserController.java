package PaymentGateway.User;

public class UserController {
    UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    User addUser(User user){
        userService.addUser(user);
        return user;
    }

    User getUser(int userId){
        return userService.getUser(userId);
    }

}
