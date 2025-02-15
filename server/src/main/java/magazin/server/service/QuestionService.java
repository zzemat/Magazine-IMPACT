package magazin.server.service;

import magazin.server.entity.Question;
import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);
    Question getQuestionById(Long id);
    List<Question> getAllQuestions();
    Question updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
}