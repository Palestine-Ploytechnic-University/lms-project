package com.lms.backend.service;

import com.lms.backend.model.Quiz;
import com.lms.backend.model.Score;
import com.lms.backend.model.User;
import com.lms.backend.payload.QuizSubmissionRequest;
import com.lms.backend.repository.QuizRepository;
import com.lms.backend.repository.ScoreRepository;
import com.lms.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssessmentService {

    private final ScoreRepository scoreRepository;
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;

    public Score recordScore(Long studentId, Long quizId, double score, String feedback) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Score s = new Score();
        s.setStudent(student);  // ✅ هنا التعديل
        s.setQuizId(quizId);
        s.setScore(score);
        s.setFeedback(feedback);
        return scoreRepository.save(s);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Score submitQuiz(QuizSubmissionRequest submission) {
        double calculatedScore = 0.0;

        return recordScore(
            submission.getStudentId(),
            submission.getQuizId(),
            calculatedScore,
            "Submitted successfully"
        );
    }

    public List<Score> getScores(Long studentId) {
        return scoreRepository.findByStudentId(studentId);
    }
}
