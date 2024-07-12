package web.dao;

import java.util.List;

import web.model.User;

public interface UserDAO {
    void addUser(User user);

    User findUser(int id);

    void editUserById(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

}
