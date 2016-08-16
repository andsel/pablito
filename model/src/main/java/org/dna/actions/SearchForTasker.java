package org.dna.actions;

import org.dna.model.SkillType;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;

import java.util.List;
import java.util.Set;

public class SearchForTasker {
    private final TaskerRepository taskerRepo;
    private Set<SkillType> desiredSkills;

    SearchForTasker(TaskerRepository taskerRepo, Set<SkillType> desiredSkills) {
        this.taskerRepo = taskerRepo;
        this.desiredSkills = desiredSkills;
    }

    public List<Tasker> execute() {
        return this.taskerRepo.findAllBySkillsAndLocation(this.desiredSkills, null, 0, 10);
    }
}
