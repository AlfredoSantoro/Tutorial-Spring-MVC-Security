package it.si2001.service;

import it.si2001.dao.SkillsDao;
import it.si2001.model.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("skillservice")
@Transactional
public class SkillServiceImpl implements SkillService {

    private SkillsDao dao;

    @Autowired
    public SkillServiceImpl(SkillsDao dao){this.dao = dao;}

    @Override
    public Skills findByName(String s) {
        return dao.findByName(s);
    }

    @Override
    public List<Skills> findAll() {
        return dao.findAll();
    }
}
