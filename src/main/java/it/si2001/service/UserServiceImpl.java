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
        return dao.allUsers(); }

    @Override
    public void save(User u) {
        dao.save(u);
    }

    @Override
    public User findById(int id) {
        return dao.findById(id); }

    @Override
    public void updateUser(User user) {
        User u = dao.findById(user.getId());
        u.setFirstname(user.getFirstname());
        u.setLastname(user.getLastname());
        u.setStatus(user.getStatus());
        u.setSkills(user.getSkills());
        u.setBirthDate(user.getBirthDate());
        u.setCountry(user.getCountry());
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }


}
