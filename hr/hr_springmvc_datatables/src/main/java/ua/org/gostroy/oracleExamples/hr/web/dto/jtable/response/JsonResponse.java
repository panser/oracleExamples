package ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.bean.JsonDepartment;

/**
 * Created by Panov Sergey on 12/7/2014.
 */
public class JsonResponse<T> {
    private String result;
    private T records;
    private String message;

    public JsonResponse(String result, T records) {
        this.result = result;
        this.records = records;
    }

    public JsonResponse(String result, String message) {
        this.result = result;
        this.message = message;
    }

    @JsonProperty("Result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty("Record")
    public T getRecords() {
        return records;
    }

    public void setRecords(T records) {
        this.records = records;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
