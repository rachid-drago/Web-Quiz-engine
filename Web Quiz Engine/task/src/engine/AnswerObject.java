package engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnswerObject {
    List<Integer> answer;

    public AnswerObject() {
    }

    public AnswerObject(List<Integer> answer) {
        this.answer = answer == null ? new ArrayList<>() : answer;
    }



    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer == null ? new ArrayList<>() : answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerObject answer1 = (AnswerObject) o;
        return this.answer.equals(answer1.answer);
    }
}
