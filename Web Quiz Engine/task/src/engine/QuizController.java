package engine;

import engine.user.User;
import engine.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




@RestController

public class QuizController {

        @Autowired
        private QuizService quizService;
        @Autowired
        private UserService userService;

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

        /*@PostMapping(value = "/api/quizzes", consumes = "application/json")
        public ResponseEntity<Quiz> saveQuiz(@RequestBody final Quiz quiz) {

            Quiz savedQuiz = quizService.saveQuiz(quiz);
            return new ResponseEntity<>(savedQuiz, HttpStatus.OK);
        }*/

        @PostMapping(path = "/api/quizzes/{id}/solve")
        public ResponseEntity<Quizanwser> solveQuiz(@RequestBody AnswerObject answer, @PathVariable Long id) {
            System.out.println(quizService.getQuizById(id).getAnswer());
            System.out.println(answer.getAnswer());
            System.out.println(quizService.getQuizById(id).getAnswer().equals(answer.getAnswer()));
            System.out.println(quizService.getQuizById(id).getAnswer().containsAll(answer.getAnswer()) && answer.getAnswer().containsAll(quizService.getQuizById(id).getAnswer()));
            Quizanwser quizanwser = Quizanwser.quizanwser(quizService.getQuizById(id).getAnswer().containsAll(answer.getAnswer()) && answer.getAnswer().containsAll(quizService.getQuizById(id).getAnswer()));
            return new ResponseEntity<>(quizanwser, HttpStatus.OK);

        }

    @PostMapping(value = "/api/quizzes", consumes = "application/json")
    public ResponseEntity<Quiz> create(@Valid @RequestBody Quiz quiz) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        quiz.setUser(user);
        return ResponseEntity.ok(quizService.saveQuiz(quiz)); }

        /*@DeleteMapping(path = "/api/quizzes/{id}")
        public ResponseEntity<String> deleteQuizById(
                @PathVariable("id") final Long id) {
            quizService.deleteQuizById(id);
            return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
        }*/

    @DeleteMapping(path = "/api/quizzes/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        quizService.delete(id, user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

