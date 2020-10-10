package engine;

import java.util.List;

public class Quizanwser {
    private boolean success = false;
    private String feedback = "no";

    public Quizanwser(boolean success, String feedback){
        this.success = success;
        this.feedback = feedback;
    }
    public Quizanwser() {}

       
    public static Quizanwser quizanwser(boolean b) {
        if (b == true) return new Quizanwser(true,"Congratulations, you're right! try catch ");
        else return new Quizanwser(false,"Wrong answer! Please, try again. try catch ");
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
