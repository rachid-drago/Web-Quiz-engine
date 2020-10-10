package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




@RestController

public class QuizController {

        @Autowired
        private QuizService quizService;


        @GetMapping(path = "/api/quizzes/{id}")
        public ResponseEntity<Quiz> getQuizById(@PathVariable("id") final Long id) {

            Quiz quiz = quizService.getQuizById(id);
            return new ResponseEntity<>(quiz, HttpStatus.OK);


        }
        @GetMapping(path = "/api/quizzes")
        public ResponseEntity<List<Quiz>> getAllQuiz() {

            List<Quiz> QuizList = quizService.getAllQuiz();
            return new ResponseEntity<>(QuizList, HttpStatus.OK);
        }

        @PostMapping(value = "/api/quizzes", consumes = "application/json")
        public ResponseEntity<Quiz> saveQuiz(@RequestBody final Quiz quiz) {

            Quiz savedQuiz = quizService.saveQuiz(quiz);
            return new ResponseEntity<>(savedQuiz, HttpStatus.OK);
        }

        @PostMapping(path = "/api/quizzes/{id}/solve")
        public ResponseEntity<Quizanwser> solveQuiz(@RequestBody AnswerObject answer, @PathVariable Long id) {
            System.out.println(quizService.getQuizById(id).getAnswer());
            System.out.println(answer.getAnswer());
            System.out.println(quizService.getQuizById(id).getAnswer().equals(answer.getAnswer()));
            System.out.println(quizService.getQuizById(id).getAnswer().containsAll(answer.getAnswer()) && answer.getAnswer().containsAll(quizService.getQuizById(id).getAnswer()));
            Quizanwser quizanwser = Quizanwser.quizanwser(quizService.getQuizById(id).getAnswer().containsAll(answer.getAnswer()) && answer.getAnswer().containsAll(quizService.getQuizById(id).getAnswer()));
            return new ResponseEntity<>(quizanwser, HttpStatus.OK);

        }

        @DeleteMapping(path = "/api/quizzes/{id}")
        public ResponseEntity<String> deleteQuizById(
                @PathVariable("id") final Long id) {
            quizService.deleteQuizById(id);
            return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
        }

}

