package engine.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import engine.view.Views;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity(name = "tasks")
public class Quiz {

    @Id
    @JsonView(Views.Public.class)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotBlank(message = "title is required")
    private String title;

    @JsonView(Views.Public.class)
    @NotBlank(message = "text is required")
    private String text;

    @JsonView(Views.Public.class)
    @ElementCollection
    @CollectionTable(name = "options", joinColumns = @JoinColumn(name = "task_id"))
    @Size(min = 2)
    @NotNull
    private List<@NotBlank(message = "option must be non empty string") String> options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ElementCollection
    @CollectionTable(name = "answer", joinColumns = @JoinColumn(name = "task_id"))
    private Set<Integer> answer;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String ownerEmail;

    public Quiz() {
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Set<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<Integer> answer) {
        this.answer = answer;
    }

    public boolean check(Set<Integer> answer) {
        if (answer == null && this.answer.size() == 0) {
            return true;
        }
        return this.answer.equals(answer);
    }

}
