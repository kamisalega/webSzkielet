package pl.salega.webszkielet.web.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by kamilsalega on 07.08.2017.
 */
@Service
public class I18NService {

    /**
     * The application logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(I18NService.class);

    @Autowired
    private MessageSource messageSource;

    /**
     * Zwraca komunikat o podanym identyfikatorze komunikatu i domyślnym locale w kontekście sesji
     *
     * @param messageId Klucz do pliku zasobów wiadomości
     *                       
     **/

    public String getMessage(String messageId) {
        LOG.info("Zwraca text i18n dla messageId {}", messageId);
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(messageId, locale);
    }

    /**
     * Zwraca komunikat o podanym identyfikatorze i locale
     *
     * @param messageId Klucz do pliku zasobów messages
     * @param locale    Locale
     **/

    public String getMessage(String messageId, Locale locale) {
        return messageSource.getMessage(messageId, null, locale);
    }
}
