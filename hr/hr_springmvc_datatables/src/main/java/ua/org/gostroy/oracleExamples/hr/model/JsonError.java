package ua.org.gostroy.oracleExamples.hr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panov Sergey on 11/11/2014.
 */
public class JsonError {
    private List<MessageError> errors = new ArrayList<>();

    public JsonError() {
    }

    public JsonError(MessageError messageError) {
        this.errors.add(messageError);
    }

    public List<MessageError> getError() {
        return errors;
    }

    public void setError(List<MessageError> errors) {
        this.errors = errors;
    }

    public void addError(MessageError messageError){
        this.errors.add(messageError);
    }
}
