package org.dna.actions;

import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;

import java.util.List;
import java.util.Set;

public class SearchForTasker {
    private final TaskerRepository taskerRepo;
    private Set<Tasker.Skill> desiredSkills;

    SearchForTasker(TaskerRepository taskerRepo, Set<Tasker.Skill> desiredSkills) {
        this.taskerRepo = taskerRepo;
        this.desiredSkills = desiredSkills;
    }

    public List<Tasker> execute() {
        return this.taskerRepo.findAllBySkills(this.desiredSkills);
    }
}
