package it.si2001.dao;

import it.si2001.model.Skills;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("skillsDao")
public class SkillsDaoImpl extends AbstractDao<Integer,Skills> implements SkillsDao {

    @Override
    public Skills findByName(String s) {
        return (Skills) getEntityManager().createQuery("select s from Skills s where s.name='" + s + "'").getSingleResult(); }

    @Override
    public List<Skills> findAll() {
        return getEntityManager().createQuery("select s from Skills s").getResultList(); }}
