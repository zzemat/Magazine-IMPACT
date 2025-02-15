package magazin.server.service.serviceImpl;

import magazin.server.entity.Answer;
import magazin.server.repository.AnswerRepository;
import magazin.server.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer getAnswerById(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        return optionalAnswer.orElse(null);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer updateAnswer(Long id, Answer answer) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            Answer existingAnswer = optionalAnswer.get();
            existingAnswer.setText(answer.getText());
            // Update other fields as necessary
            return answerRepository.save(existingAnswer);
        }
        return null;
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }
}