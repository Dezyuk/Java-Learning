package Exam.BackEndApplicationForOnlineStore.Menu.impl;

import Exam.BackEndApplicationForOnlineStore.Configs.ApplicationContext;
import Exam.BackEndApplicationForOnlineStore.Enteties.User;
import Exam.BackEndApplicationForOnlineStore.Menu.Menu;
import Exam.BackEndApplicationForOnlineStore.Services.UserManagementService;
import Exam.BackEndApplicationForOnlineStore.Services.impl.DefaultUserManagementService;

import java.util.List;
import java.util.Scanner;

public class CustomerListMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }
    @Override
    public void start() {
        printMenuHeader();
        List<User> users = userManagementService.getUsers();

        if (users == null || users.size() == 0) {
            System.out.println("Unfortunately, there are no customers.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");
    }
}
