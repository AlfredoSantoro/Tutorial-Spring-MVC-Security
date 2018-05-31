package it.si2001.dao;

import it.si2001.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao {

    @Override
    public List<User> allUsers() {
        return  getEntityManager().createQuery("select U from User U").getResultList(); }

    @Override
    public void save(User user) {
        getEntityManager().persist(user); }

    @Override
    public User findById(int id) {
        return getByKey(id); }

    @Override
    public void delete(User user) {
        getEntityManager().remove(getEntityManager().merge(user)); }

    @Override
    public User findByUsername(String username) {
        return (User) getEntityManager().createQuery("select u from User u where u.username ='" + username + "'").getSingleResult();
    }
}
