package Exam.BackEndApplicationForOnlineStore.Menu.impl;

import Exam.BackEndApplicationForOnlineStore.Configs.ApplicationContext;
import Exam.BackEndApplicationForOnlineStore.Enteties.User;
import Exam.BackEndApplicationForOnlineStore.Menu.Menu;
import Exam.BackEndApplicationForOnlineStore.Services.UserManagementService;
import Exam.BackEndApplicationForOnlineStore.Services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagemantService;

    {
        userManagemantService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter your email: ");
        String email = sc.next();
        System.out.println("Please, enter your password: ");
        String password = sc.next();
        User user = userManagemantService.getUserByEmail(email);
        if(user != null && user.getPassword().equals(password) ){
            System.out.println("Glad to see you back " + user.getFirstName() + " " + user.getLastName());
            context.setLoggedInUser(user);
        }else {
            System.out.println("Unfortunately, such login and password doesn't exist");
        }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign In *****");
    }
}
