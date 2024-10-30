package com.group2.filterism.global.config.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginSuccessHandler {
    @GetMapping("/login/success")
    public String success(@CookieValue("JSESSIONID") String sessionId) {

        return "redirect:https://filterism.netlify.app/set-cookie?sessionId=" + sessionId;
    }
}
