package com.oosulz.blog.controller;

import com.oosulz.blog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.StreamSupport;

@Controller
public class BoardController {

    @GetMapping({"", "/"})
    public String index() { //컨트롤러에서 세션을 어떻게 찾냐?
        // /WEB-INF/views"/"{index.jsp}
        return "index";
    }
    @GetMapping("/board/saveForm")
    public String saveForm() { //컨트롤러에서 세션을 어떻게 찾냐?
        // /WEB-INF/views"/"{index.jsp}
        return "board/saveForm";
    }
}
