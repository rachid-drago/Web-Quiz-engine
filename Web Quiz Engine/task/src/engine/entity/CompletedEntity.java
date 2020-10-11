package engine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CompletedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long completedId;

    private String userEmail;
    private long id;
    private Date completedAt;

    public CompletedEntity(String userEmail, long id, Date completedAt) {
        this.userEmail = userEmail;
        this.id = id;
        this.completedAt = completedAt;
    }

    public CompletedEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long quizId) {
        this.id = quizId;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }
}