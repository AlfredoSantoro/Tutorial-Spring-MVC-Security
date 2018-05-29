package it.si2001.dao;

import it.si2001.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void save(User user);
}
