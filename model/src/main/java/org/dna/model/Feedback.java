package org.dna.model;

/**
 * Value Object
 */
public class Feedback {
    private int count;
    private double rank;

    private Feedback() {}

    public Feedback(int count, double rank) {
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
