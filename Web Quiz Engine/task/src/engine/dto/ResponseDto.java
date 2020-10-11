package engine.dto;

import com.fasterxml.jackson.annotation.JsonView;
import engine.view.Views;

public class ResponseDto {
    private static final String FEEDBACK_SUCCESS = "Congratulations, you're right!";
    private static final String FEEDBACK_FAIL = "Wrong answer! Please, try again.";

    private static final ResponseDto SUCCESS = new ResponseDto(true, FEEDBACK_SUCCESS);
    private static final ResponseDto FAIL = new ResponseDto(false, FEEDBACK_FAIL);

    @JsonView(Views.Public.class)
    private boolean success;

    @JsonView(Views.Public.class)
    private String feedback;

    public ResponseDto() {
    }

    public ResponseDto(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public static ResponseDto getSuccess() {
        return SUCCESS;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static ResponseDto getFail() {
        return FAIL;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}