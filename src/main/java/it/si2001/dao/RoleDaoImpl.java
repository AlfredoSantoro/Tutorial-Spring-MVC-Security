package it.si2001.dao;

import it.si2001.model.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer,Role> implements RoleDao {


    @Override
    public Role getUserRole() {
        return (Role) getEntityManager().createQuery("select r from Role r where r.name='" + "user" + "'").getSingleResult();
    }
}
