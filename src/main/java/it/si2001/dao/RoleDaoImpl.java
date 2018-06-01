package it.si2001.dao;

import it.si2001.model.Role;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer,Role> implements RoleDao {


    @Override
    public Set<Role> getUserRole() {
        Set<Role> set = new HashSet<>();
        set.add((Role) getEntityManager().createQuery("select r from Role r where r.name='" + "user" + "'").getSingleResult());
        return set;
    }
}
