package org.dna.web.model;

import org.dna.model.Tasker;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by andrea on 16/08/16.
 */
public class TaskerView {
    private Tasker tasker;

    public TaskerView(Tasker tasker) {
        this.tasker = tasker;
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

    public static final List<TaskerView> toView(List<Tasker> taskers) {
        return taskers.stream().map(TaskerView::new).collect(toList());
    }
}
