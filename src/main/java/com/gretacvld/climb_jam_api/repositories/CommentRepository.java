package com.gretacvld.climb_jam_api.repositories;

import com.gretacvld.climb_jam_api.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTargetTypeAndTargetId(String targetType, Long targetId);
}