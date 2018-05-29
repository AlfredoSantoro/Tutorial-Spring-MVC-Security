package it.si2001.service;

import it.si2001.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    void save(User u);
}
