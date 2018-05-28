package it.si2001.dao;

import it.si2001.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao {


    @Override
    public List<User> allUsers() {

        return  null;
    }
}
