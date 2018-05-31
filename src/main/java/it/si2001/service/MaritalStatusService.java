package it.si2001.service;

import it.si2001.model.MaritalStatus;

import java.util.List;

public interface MaritalStatusService {
    MaritalStatus findByName(String name);
    List<MaritalStatus> findAllStatus();}
