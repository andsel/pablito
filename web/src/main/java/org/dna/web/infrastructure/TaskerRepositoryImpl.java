package org.dna.web.infrastructure;

import org.dna.model.SkillType;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

public class TaskerRepositoryImpl implements TaskerRepository {

    private JPATaskerDAO taskerDAO;

    @Autowired
    TaskerRepositoryImpl(JPATaskerDAO taskerDAO) {
        this.taskerDAO = taskerDAO;
    }

    @Override
    public List<Tasker> findAllBySkills(Set<SkillType> skills) {
        return findAllBySkills(skills, 0, 10);
    }

    @Override
    public List<Tasker> findAllBySkills(Set<SkillType> skills, long max, int offset) {
        PageRequest paging = new PageRequest((int)max/offset, offset);
        if (CollectionUtils.isEmpty(skills)) {
            return this.taskerDAO.findAll(paging).getContent();
        }
        //TODO use all skills, not just the first one
        SkillType skill = skills.iterator().next();
        return this.taskerDAO.findBySkillsContaining(skill, paging).getContent();
    }

    @Override
    public long countAllBySkills(Set<SkillType> skills) {
        if (CollectionUtils.isEmpty(skills)) {
            return this.taskerDAO.count();
        }
        //TODO use all skills, not just the first one
        SkillType skill = skills.iterator().next();
        return this.taskerDAO.countBySkillsContaining(skill);
    }

    @Override
    public Tasker getByID(long possibleTasker) {
        return this.taskerDAO.getOne(possibleTasker);
    }

    @Override
    public Tasker save(Tasker tasker) {
        return this.taskerDAO.save(tasker);
    }
}
