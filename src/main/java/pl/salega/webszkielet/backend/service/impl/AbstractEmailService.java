package pl.salega.webszkielet.backend.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import pl.salega.webszkielet.backend.service.EmailService;
import pl.salega.webszkielet.web.domain.frontend.FeedbackPojo;

/**
 * Created by kamilsalega on 08.08.2017.
 */
public abstract class AbstractEmailService implements EmailService {

    @Value("${default.to.address}")
    private String defaultToAddress;


    protected SimpleMailMessage prepareSimpleMessageFromFeedbackPojo(FeedbackPojo feedbackPojo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAddress);
        message.setFrom(feedbackPojo.getEmail());
        message.setSubject("[Web Szkielet]: otrzymałeś opinie od" + feedbackPojo.getFirstName() + " "
                + feedbackPojo.getLastName() + "!");
        message.setText(feedbackPojo.getFeedback());
        return message;
    }

    @Override
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
        sendGenericEmailMessage(prepareSimpleMessageFromFeedbackPojo(feedbackPojo));
    }
}
