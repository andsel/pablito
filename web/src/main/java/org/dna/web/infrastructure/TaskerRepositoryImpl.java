package org.dna.web.infrastructure;

import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class TaskerRepositoryImpl implements TaskerRepository {

    private JPATaskerDAO taskerDAO;

    @Autowired
    TaskerRepositoryImpl(JPATaskerDAO taskerDAO) {
        this.taskerDAO = taskerDAO;
    }

    @Override
    public List<Tasker> findAllBySkills(Set<Tasker.Skill> skills) {
        return null;
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
