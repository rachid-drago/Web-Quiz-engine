package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<Quiz> getAllQuiz() {
        return (List<Quiz>) quizRepository.findAll();
    }

    @Override
    public Quiz getQuizById(Long id) throws IdNotFoundException {
        try {
            quizRepository.findById(id).get();
        } catch (Exception e) {
            throw new IdNotFoundException("id not found");
        }
        return quizRepository.findById(id).get();
    }

    @Override
    public Quiz saveQuiz(final Quiz quiz) {
        if (quiz.getTitle() == "" || quiz.getText() == "" || quiz.getOptions().isEmpty() )  throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Actor Not Found");
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updatePlanetById(int id, Quiz QuizToUpdate) {
        return null;
    }

    @Override
    public void deleteQuizById(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public List<Quiz> getQuizByNameContaining(String searchString) {
        return null;
    }

    @Override
    public List<Quiz> getQuizByNameLike(String searchString) {
        return null;
    }

    @Override
    public boolean correctAnswer(List<Integer> answer, Long id) {

        return false;
    }
}
