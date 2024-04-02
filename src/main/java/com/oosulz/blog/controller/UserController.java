package com.oosulz.blog.controller;

import com.oosulz.blog.config.auth.PrincipalDetail;
import org.springframework.data.querydsl.binding.MultiValueBinding;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


//인증이 안된 사용자들이 출입할 수 있는 경로 /auth/** 허용
// 그냥 주소가 / 이면 index.jsp 허용
// static 이하에 있는 /js/**, /css/** , /image/**
@Controller
public class UserController {
    @GetMapping("/auth/joinForm")
    public String joinForm(){

        return "user/joinForm";
    }
    @GetMapping("/auth/loginForm")
    public String loginForm(){

        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm(@AuthenticationPrincipal PrincipalDetail principal){

        return "user/updateForm";
    }

    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String kakaoCallback(String code){
        // post 방식으로 key-value 타입 데이터를 요청 해야함.
        // a 태그 불가 -> a태그 get 방식만 가능
        RestTemplate rt = new RestTemplate(); //http 요청 편하게 가능 Retrofit2 / okhttp/ resttemplate

        // HttpHeaders 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        // HttpBody 오브젝트 생성
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "fc9a495f12d3bf5094703df4a9d10434");
        params.add("redirect_url", "https://localhost:8000/auth/kakao/callback");
        params.add("code", code);

        // HttpEntity = HttpHeaders + HttpBody 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
                new HttpEntity<>(params,headers);

        // 파라미터로 HttpEntity를 받음
        // http 요청 포스트방식으로 / response 변수에 응답받음
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
                );

        return "카카오 인증 완료 " + response;
    }

}
