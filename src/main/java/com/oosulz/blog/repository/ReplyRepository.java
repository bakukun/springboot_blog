package com.oosulz.blog.repository;

import com.oosulz.blog.model.Board;
import com.oosulz.blog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Integer> {
}
