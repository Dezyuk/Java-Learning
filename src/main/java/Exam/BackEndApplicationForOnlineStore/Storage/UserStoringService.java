package Exam.BackEndApplicationForOnlineStore.Storage;

import Exam.BackEndApplicationForOnlineStore.Enteties.User;

import java.util.List;

public interface UserStoringService {
    void saveUser(User user);
    List<User> loadUsers();
}
