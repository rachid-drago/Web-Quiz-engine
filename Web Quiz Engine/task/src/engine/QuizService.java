package engine;

import engine.user.User;

import java.util.List;

public interface QuizService {
    List<Quiz> getAllQuiz();
    /**
     * Get Quiz By Id.
     * @param id Id
     * @return Quiz
     */
    Quiz getQuizById(Long id);
    /**
     * Save Quiz.
     * @param quiz quiz to save
     * @return Saved quiz
     */
    Quiz saveQuiz(Quiz quiz);
    /**
     * Update Planet.
     * @param id Id
     * @param QuizToUpdate Quiz to Update
     * @return Updated Quiz
     */
    Quiz updatePlanetById(int id, Quiz QuizToUpdate);
    /**
     * Delete Quiz by Id.
     * @param id Id
     */
    void deleteQuizById(Long id);
    /**
     * Search Quiz by name containing.
     * @param searchString SearchString
     * @return Search result
     */
    List<Quiz> getQuizByNameContaining(String searchString);
    /**
     * Search Quiz by name like.
     * @param searchString SearchString
     * @return Search result
     */
    List<Quiz> getQuizByNameLike(String searchString);

    boolean correctAnswer(List<Integer> answer, Long id);

    public void delete(long id, User user);
}
