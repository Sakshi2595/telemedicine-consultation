package com.stackroute.telemedicineconsultation.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebappControlleer {
    @GetMapping("/")
    public String getIndex() {
        return "index.html";
    }
}
