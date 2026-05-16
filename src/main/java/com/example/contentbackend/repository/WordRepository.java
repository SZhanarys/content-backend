package com.example.contentbackend.repository;

import com.example.contentbackend.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByTopicId(Long topicId);
}
