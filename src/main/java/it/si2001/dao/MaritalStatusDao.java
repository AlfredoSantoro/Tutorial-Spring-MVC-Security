package it.si2001.dao;

import it.si2001.model.MaritalStatus;

import java.util.List;

public interface MaritalStatusDao {

    MaritalStatus findByName(String name);
    List<MaritalStatus> findALl();
}
