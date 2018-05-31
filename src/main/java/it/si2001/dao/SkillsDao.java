package it.si2001.dao;

import it.si2001.model.Skills;

import java.util.List;

public interface SkillsDao {
    Skills findByName(String s);
    List<Skills> findAll();}
