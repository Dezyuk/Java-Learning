package OOP.SingleResponsibilityPrinciple;

public class UserAuthenticator {
    public static boolean authenticateUser(String username, String password) {
//        <write your code here>
        return UserValidator.validateUsername(username) && UserValidator.validatePassword(password);
    }
}
