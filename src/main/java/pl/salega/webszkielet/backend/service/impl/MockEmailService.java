package pl.salega.webszkielet.backend.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by kamilsalega on 08.08.2017.
 */
public class MockEmailService extends AbstractEmailService {

    /**
     * The application logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage simpleMailMessage) {
        LOG.debug("symulacja obslugi emaila...");
        LOG.info(simpleMailMessage.toString());
        LOG.debug("Email wyslany!");

    }
}
