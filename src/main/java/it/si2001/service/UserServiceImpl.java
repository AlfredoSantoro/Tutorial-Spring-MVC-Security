package it.si2001.service;

import it.si2001.dao.UserDao;
import it.si2001.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.dao = userDao; }

    @Override
    public List<User> findAllUsers() {
        return dao.allUsers(); }}
