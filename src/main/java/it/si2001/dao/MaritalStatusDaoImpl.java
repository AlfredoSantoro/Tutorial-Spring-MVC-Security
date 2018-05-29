package it.si2001.dao;

import it.si2001.model.MaritalStatus;
import org.springframework.stereotype.Repository;

@Repository("MaritalStatusDao")
public class MaritalStatusDaoImpl extends AbstractDao<Integer,MaritalStatus> implements MaritalStatusDao {




    @Override
    public MaritalStatus findByName(String name) {
        return (MaritalStatus) getEntityManager().createQuery("select m from MaritalStatus m where m.status = '" + name + "'").getSingleResult();
    }
}
