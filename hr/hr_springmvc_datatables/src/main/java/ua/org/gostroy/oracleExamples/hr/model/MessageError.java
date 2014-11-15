package ua.org.gostroy.oracleExamples.hr.model;

/**
 * Created by Panov Sergey on 11/11/2014.
 */
public class MessageError {
    private String message;
    private Integer code;

    public MessageError() {
    }

    public MessageError(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
