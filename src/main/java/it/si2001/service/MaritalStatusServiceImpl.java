package it.si2001.service;

import it.si2001.dao.MaritalStatusDao;
import it.si2001.model.MaritalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("maritalStatusService")
@Transactional
public class MaritalStatusServiceImpl implements MaritalStatusService {

    private
    MaritalStatusDao dao;

    @Autowired
    public MaritalStatusServiceImpl(MaritalStatusDao dao){ this.dao = dao;}


    @Override
    public MaritalStatus findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<MaritalStatus> findAllStatus() {
        return dao.findALl();
    }
}
