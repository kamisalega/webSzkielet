package pl.salega.webszkielet.backend.service;

import org.springframework.mail.SimpleMailMessage;
import pl.salega.webszkielet.web.domain.frontend.FeedbackPojo;

/**
 * Created by kamilsalega on 08.08.2017.
 */
public interface EmailService {

    public void sendFeedbackEmail(FeedbackPojo feedbackPojo);

    public void sendGenericEmailMessage(SimpleMailMessage simpleMailMessage);
}
