package org.dna.model;

import java.util.Date;

/**
 * value object, model a message of chat between a Tasker and a TaskBidder
 */
public class Message {
    public enum Direction {
        WORKER_TO_BIDDER, BIDDER_TO_WORKER
    }
    private String text;
    private Date createdOn;
    private Direction direction;

    private Message() {}

    public Message(String text, Date createdOn, Direction direction) {
        this.text = text;
        this.createdOn = createdOn;
        this.direction = direction;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Direction getDirection() {
        return direction;
    }
}
