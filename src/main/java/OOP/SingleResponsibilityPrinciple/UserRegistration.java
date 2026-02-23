package OOP.SingleResponsibilityPrinciple;

public class UserRegistration {
    public static boolean registerUser(String username, String password) {
//        <write your code here>
        // Register user in the database
        return UserValidator.validateUsername(username) && UserValidator.validatePassword(password);
    }
}
