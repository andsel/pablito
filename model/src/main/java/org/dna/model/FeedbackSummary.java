package org.dna.model;

/**
 * Value Object
 */
public class FeedbackSummary {
    private int count;
    private double rank;

    private FeedbackSummary() {}

    public FeedbackSummary(int count, double rank) {
        this.count = count;
        this.rank = rank;
    }

    public int getCount() {
        return count;
    }

    public double getRank() {
        return rank;
    }
}
