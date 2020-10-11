package engine.service;

import engine.exception.NotFoundException;
import engine.dto.SolveDto;
import engine.entity.Quiz;
import engine.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Page<Quiz> findAll(Pageable paging) {
        return quizRepository.findAll(paging);
    }

    public Quiz getById(long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if (quiz.isPresent()) {
            return quiz.get();
        }
        throw new NotFoundException();
    }

    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz update(long id, Quiz newQuiz) {
        quizRepository.deleteById(id);

        Quiz quizToUpdate = new Quiz();

        quizToUpdate.setId(id);
        quizToUpdate.setTitle(newQuiz.getTitle());
        quizToUpdate.setText(newQuiz.getText());
        quizToUpdate.setOptions(newQuiz.getOptions());
        quizToUpdate.setAnswer(newQuiz.getAnswer());

        quizRepository.save(quizToUpdate);
        return quizToUpdate;
    }

    public boolean solve(Quiz quiz, SolveDto answer) {
        return quiz.check(answer.getAnswer());
    }

    public void deleteById(long id) {
        quizRepository.deleteById(id);
    }

}