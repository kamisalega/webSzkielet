package pl.salega.webszkielet.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.salega.webszkielet.backend.service.EmailService;
import pl.salega.webszkielet.web.domain.frontend.FeedbackPojo;

/**
 * Created by kamilsalega on 08.08.2017.
 */
@Controller
public class ContactController {

    /**
     * The application logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    private static final String FEEDBACK_MODEL_KEY = "feedback";
    private static final String CONTACT_US_VIEW_NAME = "contact/contact";

    @Autowired
    private EmailService emailService;




    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactGet(ModelMap model) {
        FeedbackPojo feedbackPojo = new FeedbackPojo();
        model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
        return ContactController.CONTACT_US_VIEW_NAME;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedbackPojo) {
        LOG.debug("Feedback POJO content: {}", feedbackPojo);
        emailService.sendFeedbackEmail(feedbackPojo);
        return ContactController.CONTACT_US_VIEW_NAME;
    }
}
