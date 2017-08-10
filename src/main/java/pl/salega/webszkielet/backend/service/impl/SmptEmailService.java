package pl.salega.webszkielet.backend.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by kamilsalega on 08.08.2017.
 */
public class SmptEmailService extends AbstractEmailService {
    
    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(SmptEmailService.class);

    @Autowired
    private MailSender mailSender;
    
    @Override
    public void sendGenericEmailMessage(SimpleMailMessage simpleMailMessage) {
        LOG.debug("Wyslij email do: {}", simpleMailMessage);
        mailSender.send(simpleMailMessage);
        LOG.info("Email wyslany.");
        
    }
}
