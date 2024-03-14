package com.oosulz.blog.controller;

import com.oosulz.blog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.StreamSupport;

@Controller
public class BoardController {

    @GetMapping({"", "/"})
    public String index(@AuthenticationPrincipal PrincipalDetail principal) { //컨트롤러에서 세션을 어떻게 찾냐?
        // /WEB-INF/views"/"{index.jsp}
        System.out.println("로그인 사용자 아이디: "+ principal.getUsername());
        return "index";
    }
}
