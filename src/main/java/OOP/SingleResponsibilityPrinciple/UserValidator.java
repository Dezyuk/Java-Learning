package OOP.SingleResponsibilityPrinciple;

public class UserValidator {
    public static boolean validateUsername(String username) {
//        <write your code here>
        return username.length() >= 5 && username.matches("[a-zA-Z_0-9]+");

    }

    public static boolean validatePassword(String password) {
//        <write your code here>
        return password.length() >= 8 && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }
}
