package it.si2001.dao;

import it.si2001.model.MaritalStatus;

public interface MaritalStatusDao {

    MaritalStatus findByName(String name);
}
