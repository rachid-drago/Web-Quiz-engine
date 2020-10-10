package engine.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuizException extends RuntimeException {
    public QuizException(String s) {
        super(s);
    }
}
