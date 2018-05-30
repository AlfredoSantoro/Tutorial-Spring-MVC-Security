package it.si2001.dao;

import it.si2001.model.MaritalStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("maritalStatusDao")
public class MaritalStatusDaoImpl extends AbstractDao<Integer,MaritalStatus> implements MaritalStatusDao {

    @Override
    public MaritalStatus findByName(String name) {
        return (MaritalStatus) getEntityManager().createQuery("select m from MaritalStatus m where m.status ='" + name + "'").getSingleResult(); }

    @Override
    public List<MaritalStatus> findALl() { return getEntityManager().createQuery("select m from MaritalStatus m").getResultList(); } }
