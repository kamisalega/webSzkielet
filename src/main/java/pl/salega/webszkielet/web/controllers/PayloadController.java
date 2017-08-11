package pl.salega.webszkielet.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kamilsalega on 11.08.2017.
 */
@Controller
public class PayloadController {
    public static final String PAYLOAD_VIEW_NAME = "payload/payload";

    @RequestMapping("/payload")
    public String payLoad() {
        return PAYLOAD_VIEW_NAME;
    }
}
