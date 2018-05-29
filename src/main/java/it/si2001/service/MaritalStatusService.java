package it.si2001.service;

import it.si2001.model.MaritalStatus;

public interface MaritalStatusService {

    MaritalStatus findByName(String name);
}
