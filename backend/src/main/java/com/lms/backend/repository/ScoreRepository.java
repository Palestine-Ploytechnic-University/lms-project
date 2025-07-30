package com.lms.backend.repository;

import com.lms.backend.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByStudentId(Long studentId);
    List<Score> findByQuizId(Long quizId);
}
