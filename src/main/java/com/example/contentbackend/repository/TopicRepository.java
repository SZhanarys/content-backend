package com.example.contentbackend.repository;

import com.example.contentbackend.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByLevel(String level);
}
