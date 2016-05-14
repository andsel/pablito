package org.dna.actions;

import org.dna.model.Criteria;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;

import java.util.List;

public class SearchForTasker {
    private final TaskerRepository taskerRepo;
    private Criteria<Tasker> searchCriteria;

    SearchForTasker(TaskerRepository taskerRepo, Criteria<Tasker> searchCriteria) {
        this.taskerRepo = taskerRepo;
        this.searchCriteria = searchCriteria;
    }

    public List<Tasker> execute() {
        return this.taskerRepo.findAllByCriteria(this.searchCriteria);
    }
}
