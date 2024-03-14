package com.oosulz.blog.service;

import com.oosulz.blog.model.RoleType;
import com.oosulz.blog.model.User;
import com.oosulz.blog.repository.UserRepository;
import jakarta.persistence.TableGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void 회원가입(User user){
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }
    /*
    @Transactional(readOnly = true) //Select 시 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성 유지)
    public Optional<User> 로그인(User user){
        return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());

    }
     */
}
