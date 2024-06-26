package com.oosulz.blog.config.auth;

import com.oosulz.blog.model.User;
import com.oosulz.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    //스프링이 로그인 요청을 가로챌때, username,password 변수 2개를 가로채는데
    // password 부분 처리는 알아서 함
    // username이 DB 에 있는 지 확인
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다."+username));
        return new PrincipalDetail(principal); //시큐리티의 세션에 유저정보가 저장
    }
}
