package org.dna.model;

/**
 * Value object to map a Tasker review provided by a TaskBidder.
 */
public class Review {

    private String comment;
    private double rank;

    private Review() {}

    public Review(String comment, double rank) {
        this.comment = comment;
        this.rank = rank;
    }

    public String getComment() {
        return comment;
    }

    public double getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (Double.compare(review.rank, rank) != 0) return false;
        return comment != null ? comment.equals(review.comment) : review.comment == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = comment != null ? comment.hashCode() : 0;
        temp = Double.doubleToLongBits(rank);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
