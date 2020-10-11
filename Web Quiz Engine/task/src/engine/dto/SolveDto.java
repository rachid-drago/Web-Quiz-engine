package engine.dto;

import com.fasterxml.jackson.annotation.JsonView;
import engine.view.Views;

import java.util.Set;

public class SolveDto {

    @JsonView(Views.Public.class)
    private Set<Integer> answer;

    public SolveDto() {
    }

    public SolveDto(Set<Integer> answer) {
        this.answer = answer;
    }

    public Set<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<Integer> answer) {
        this.answer = answer;
    }

}