package org.dna.web.model;

import org.dna.model.Ability;
import org.dna.model.Competence;
import org.dna.model.Tasker;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Tasker view model, wraps the model's Tasker.
 */
public class TaskerView {
    private Tasker tasker;
    private Set<Ability> leftSideAbilities = new HashSet<>();
    private Set<Ability> rightSideAbilities = new HashSet<>();

    public TaskerView(Tasker tasker) {
        this.tasker = tasker;
        List<Ability> tmpAbilities = new ArrayList<>(this.tasker.getAbilities());
        int halfSize = (int) Math.ceil(tmpAbilities.size() / 2);
        leftSideAbilities.addAll(tmpAbilities.subList(0, halfSize));
        rightSideAbilities.addAll(tmpAbilities.subList(halfSize, tmpAbilities.size()));
    }

    public Long getId() {
        return this.tasker.getId();
    }

    public String getName() {
        return this.tasker.getName();
    }

    public String getMainSkill() {
        return this.tasker.getMainSkill();
    }

    public String getPresentation() {
        return this.tasker.getPresentation();
    }

    public String getLocation() {
        return this.tasker.getLocation();
    }

    public String getNation() {
        return this.tasker.getNation();
    }

    public int getFeedbackCount() {
        return this.tasker.getFeedback().getCount();
    }

    public int getFeedbackRank() {
        return Math.max(0, (int) Math.round(Math.floor(this.tasker.getFeedback().getRank())) - 1);
    }

    public Set<Competence> getCompetences() {
        return this.tasker.getCompetences();
    }

    public Set<Ability> getLeftSideAbilities() {
        return leftSideAbilities;
    }

    public Set<Ability> getRightSideAbilities() {
        return rightSideAbilities;
    }

    public static final List<TaskerView> toView(List<Tasker> taskers) {
        return taskers.stream().map(TaskerView::new).collect(toList());
    }
}
