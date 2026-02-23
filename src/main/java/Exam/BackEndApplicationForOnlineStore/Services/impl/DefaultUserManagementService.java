package Exam.BackEndApplicationForOnlineStore.Services.impl;

import Exam.BackEndApplicationForOnlineStore.Enteties.User;
import Exam.BackEndApplicationForOnlineStore.Services.UserManagementService;

import java.util.Arrays;

public class DefaultUserManagementService implements UserManagementService {
    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";
    private static final int DEFAULT_USERS_CAPACITY = 10;

    private User[] users;
    private int lastIndex;

    private static DefaultUserManagementService instance;

    {
        users = new User[DEFAULT_USERS_CAPACITY];
    }

    public DefaultUserManagementService() {

    }

    public static UserManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultUserManagementService();
        }
        return instance;
    }

    @Override
    public String registerUser(User user) {
        if (user == null) {
            return NO_ERROR_MESSAGE;
        }

        String errorMessage = checkUniqueEmail(user.getEmail());
        if (errorMessage != null && !errorMessage.isEmpty()) {
            return errorMessage;
        }

        if (users.length <= lastIndex) {
            users = Arrays.copyOf(users, users.length << 1);
        }

        users[lastIndex++] = user;
        return NO_ERROR_MESSAGE;
    }

    private String checkUniqueEmail(String email) {
        if (email == null || email.isEmpty()) {
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }
        for (User user : users) {
            if (user != null &&
                    user.getEmail() != null &&
                    user.getEmail().equalsIgnoreCase(email)) {
                return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
            }
        }
        return NO_ERROR_MESSAGE;
    }

    @Override
    public User[] getUsers() {
        if (users == null) {
            return new User[0];
        }
        int notNullUsers = 0;
        for (User user : users) {
            if (user != null) {
                notNullUsers++;
            }
        }
        int index = 0;
        User[] notNullUser = new User[notNullUsers];
        for (User user : users) {
            if (user != null) {
                notNullUser[index++] = user;
            }
        }
        return notNullUser;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        for (User user : users) {
            if (user != null && user.getEmail().equalsIgnoreCase(userEmail)) {
                return user;
            }
        }
        return null;
    }

    void clearServiceState() {
        lastIndex = 0;
        users = new User[DEFAULT_USERS_CAPACITY];
    }
}
