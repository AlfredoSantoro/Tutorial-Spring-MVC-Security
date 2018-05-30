package it.si2001.converter;

import it.si2001.model.Skills;
import it.si2001.service.SkillService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

@Component
public class SkillConverter implements Converter<Object, Skills>
{
    private SkillService skillService;

    @Autowired
    public SkillConverter(SkillService skillService) { this.skillService = skillService; }

    public Skills convert(Object element) { return skillService.findByName((String) element); }
}
