package com.oosulz.blog.service;

import com.oosulz.blog.model.Board;
import com.oosulz.blog.model.RoleType;
import com.oosulz.blog.model.User;
import com.oosulz.blog.repository.BoardRepository;
import com.oosulz.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void 글쓰기(Board board,User user){ //title,content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

}
