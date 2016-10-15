package org.dna.model;

import java.util.Date;

/**
 * value object, model a message of chat between a Tasker and a TaskBidder
 */
public class Message {
    private String text;
    private Date createdOn;

    private Message() {}

    public Message(String text, Date createdOn) {
        this.text = text;
        this.createdOn = createdOn;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
}
