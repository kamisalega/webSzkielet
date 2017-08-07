package pl.salega.webszkielet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.salega.webszkielet.web.i18n.I18NService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebszkieletApplication.class)
@WebAppConfiguration
public class WebszkieletApplicationTests {



    @Autowired
    private I18NService i18NService;

    @Test
    public void testMessageByLocaleService() throws Exception {
		String expectedResults = "Bootstrap starter template";
		String messageId = "index.main.callout";
		String actual = i18NService.getMessage(messageId);
        Assert.assertEquals("The actual and expected String don't match", expectedResults, actual);
    }
}
