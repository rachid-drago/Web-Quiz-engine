package engine.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import engine.exception.NotFoundException;
import engine.entity.User;
import engine.view.Views;
import engine.dto.ResponseDto;
import engine.dto.SolveDto;
import engine.entity.CompletedEntity;
import engine.entity.Quiz;
import engine.repository.CompletedRepository;
import engine.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController()
public class QuizController {
    private final QuizService quizService;

    private final CompletedRepository completedRepository;

    @Autowired
    public QuizController(QuizService quizService, CompletedRepository completedRepository) {
        this.quizService = quizService;
        this.completedRepository = completedRepository;
    }

    @GetMapping("/api/quizzes")
    public Page<Quiz> getQuizzes(@RequestParam(required = false, defaultValue = "0", name = "page") int page) {
        int pageSize = 10;
        Pageable paging = PageRequest.of(page, pageSize, Sort.by("id").descending());
        return quizService.findAll(paging);
    }

    @GetMapping("/api/quizzes/completed")
    public Page<CompletedEntity> getCompleted(@RequestParam(required = false, defaultValue = "0", name = "page") int page) {
        int pageSize = 10;
        Pageable paging = PageRequest.of(page, pageSize, Sort.by("completedAt").descending());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return completedRepository.findAllByUserEmail(user.getEmail(), paging);
    }

    @JsonView(Views.Public.class)
    @GetMapping("/api/quizzes/{id}")
    public Quiz getById(@PathVariable long id) {
        return quizService.getById(id);
    }

    @JsonView(Views.Public.class)
    @PostMapping("/api/quizzes")
    public Quiz addQuiz(@Valid @RequestBody Quiz quiz) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        quiz.setOwnerEmail(user.getEmail());
        return quizService.add(quiz);
    }

    @PostMapping(path = "/api/quizzes/{id}/solve")
    public ResponseDto solveQuiz(@PathVariable long id, @Valid @RequestBody SolveDto solveDto) {
        if (quizService.solve(quizService.getById(id), solveDto)) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            completedRepository.save(new CompletedEntity(user.getEmail(), id, new Date()));
            return ResponseDto.getSuccess();
        } else {
            return ResponseDto.getFail();
        }
    }

    @PutMapping(path = "/api/quizzes/{id}")
    public ResponseEntity<String> updateQuiz(@PathVariable long id, @Valid @RequestBody Quiz newQuiz) {
        try {
            Quiz quiz = quizService.getById(id);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!quiz.getOwnerEmail().equals(user.getEmail())) {
                return new ResponseEntity<>("You cannot change another user's quiz", HttpStatus.FORBIDDEN);
            }
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return new ResponseEntity<>(ow.writeValueAsString(quizService.update(id, newQuiz)), HttpStatus.OK);
        } catch (NotFoundException | JsonProcessingException e) {
            return new ResponseEntity<>("Quiz with id: " + id + " doesn't exist.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/api/quizzes/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable long id) {
        try {
            Quiz quiz = quizService.getById(id);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!quiz.getOwnerEmail().equals(user.getEmail())) {
                return new ResponseEntity<>("You cannot delete another user's quiz", HttpStatus.FORBIDDEN);
            }
            quizService.deleteById(id);
            return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Quiz with id: " + id + "doesn't exist.", HttpStatus.NOT_FOUND);
        }
    }

}