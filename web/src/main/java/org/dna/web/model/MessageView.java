package org.dna.web.model;

import org.dna.model.Message;
import org.dna.model.TaskOffer;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Message domain class wrapper
 */
public class MessageView {

    private final Date createdOn;
    private final String text;
    private final boolean leftSide;
    private final String author;

    public MessageView(Message message, TaskOffer offer, boolean taskerIsTheViewer) {
        this.createdOn = message.getCreatedOn();
        this.text = message.getText();
        boolean fromBidderToWorker = message.getDirection() == Message.Direction.BIDDER_TO_WORKER;
        this.leftSide = fromBidderToWorker && taskerIsTheViewer;
        this.author = fromBidderToWorker ? offer.getBidder().getLogin() : offer.getWorker().getName();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getText() {
        return text;
    }

    public boolean isLeftSide() {
        return leftSide;
    }

    public String getAuthor() {
        return author;
    }

    public static List<MessageView> toTaskerView(List<Message> messages, TaskOffer offer) {
        return messages.stream().map(it -> new MessageView(it, offer, true)).collect(toList());
    }

    public static List<MessageView> toBidderView(List<Message> messages, TaskOffer offer) {
        return messages.stream().map(it -> new MessageView(it, offer, false)).collect(toList());
    }
}
