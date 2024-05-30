package com.edu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.Reply;

@Repository
public interface ReplyRepository extends CrudRepository<Reply, Integer> {

}
