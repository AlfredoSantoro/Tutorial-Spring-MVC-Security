package it.si2001.service;

import it.si2001.model.Skills;

import java.util.List;

public interface SkillService {
    Skills findByName(String s);
    List<Skills> findAll();}
