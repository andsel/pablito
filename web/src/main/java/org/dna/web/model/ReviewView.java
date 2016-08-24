package org.dna.web.model;

import org.dna.model.Review;

/**
 * Review view model, wraps Review
 */
public class ReviewView {

    private final Review review;

    ReviewView(Review review) {
        this.review = review;
    }

    public String getComment() {
        return this.review.getComment();
    }

    /**
     * Normalize to int the review rank
     * */
    public int getRank() {
        return Math.max(0, (int) Math.round(Math.floor(this.review.getRank())) - 1);
    }
}
