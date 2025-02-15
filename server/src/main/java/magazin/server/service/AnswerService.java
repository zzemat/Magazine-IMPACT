package magazin.server.service;

import magazin.server.entity.Answer;

import java.util.List;

public interface AnswerService {
    Answer createAnswer(Answer answer);
    Answer getAnswerById(Long id);
    List<Answer> getAllAnswers();
    Answer updateAnswer(Long id, Answer answer);
    void deleteAnswer(Long id);
}