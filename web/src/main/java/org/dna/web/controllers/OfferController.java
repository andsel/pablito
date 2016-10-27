package org.dna.web.controllers;

import org.dna.model.TaskOffer;
import org.dna.model.TaskOfferRepository;
import org.dna.web.model.MessageView;
import org.dna.web.model.TaskerHireRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * UI controller for TaskOffers
 */
@Controller
public class OfferController {

    private static final Logger LOG = LoggerFactory.getLogger(OfferController.class);

    @Autowired
    protected TaskOfferRepository offerRepository;

    @RequestMapping(value = "/offer/{offerId}/details", method = RequestMethod.GET)
    public String detail(@PathVariable("offerId") long offerId, Model model) {
        LOG.info("Request detail for offer {}", offerId);
        TaskOffer offer = this.offerRepository.getByID(offerId);
        List<MessageView> messages = MessageView.toTaskerView(offer.listMessages(), offer);
        model.addAttribute("offer", offer);
        model.addAttribute("messages", messages);

        List<TaskOffer> pendingRequests = this.offerRepository.pendingRequests(offer.getWorker());
        model.addAttribute("pendingRequests", pendingRequests);
        model.addAttribute("countRequests", pendingRequests.size());

        return "offer_detail";
    }

    @RequestMapping(value = "/offer/{offerId}/message", method = RequestMethod.POST)
    public String appendNewMessage(@PathVariable("offerId") long offerId,
                                   @ModelAttribute String newMessage,
                                   Model model) {
        LOG.info("Appending a message for offer {}", offerId);
        TaskOffer offer = this.offerRepository.getByID(offerId);

        offer.messageToBidder(newMessage);
        this.offerRepository.save(offer);

        List<MessageView> messages = MessageView.toTaskerView(offer.listMessages(), offer);
        model.addAttribute("offer", offer);
        model.addAttribute("messages", messages);

        List<TaskOffer> pendingRequests = this.offerRepository.pendingRequests(offer.getWorker());
        model.addAttribute("pendingRequests", pendingRequests);
        model.addAttribute("countRequests", pendingRequests.size());

        return "offer_detail";
    }
}
