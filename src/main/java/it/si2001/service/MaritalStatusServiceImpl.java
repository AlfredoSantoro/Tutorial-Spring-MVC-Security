package it.si2001.service;

import it.si2001.dao.MaritalStatusDao;
import it.si2001.model.MaritalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MaritalStatusService")
public class MaritalStatusServiceImpl implements MaritalStatusService {

    private MaritalStatusDao service;

    @Autowired
    public MaritalStatusServiceImpl(MaritalStatusDao m){this.service=m;}

    @Override
    public MaritalStatus findByName(String name) {
        return service.findByName(name);
    }
}
