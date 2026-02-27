package Exam.BackEndApplicationForOnlineStore.Services;

import Exam.BackEndApplicationForOnlineStore.Enteties.User;

import java.util.List;

public interface UserManagementService {
    String registerUser(User user);
    List<User> getUsers();
    User getUserByEmail(String userEmail);

}
