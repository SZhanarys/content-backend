package com.example.contentbackend.controller;

import com.example.contentbackend.model.Topic;
import com.example.contentbackend.model.Word;
import com.example.contentbackend.repository.TopicRepository;
import com.example.contentbackend.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin(origins = "*") // Чтобы Flutter мог делать запросы
public class ContentController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private WordRepository wordRepository;

    // 1. Получить список тем по уровню (например: /api/content/topics/A1)
    @GetMapping("/topics/{level}")
    public ResponseEntity<List<Topic>> getTopics(@PathVariable String level) {
        List<Topic> topics = topicRepository.findByLevel(level);
        return ResponseEntity.ok(topics);
    }

    // 2. Получить список слов по ID темы (например: /api/content/words/1)
    @GetMapping("/words/{topicId}")
    public ResponseEntity<List<Word>> getWords(@PathVariable Long topicId) {
        List<Word> words = wordRepository.findByTopicId(topicId);
        return ResponseEntity.ok(words);
    }
}