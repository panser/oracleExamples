package ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
public class JsonOptionsResponse {

    private String result;
    private List<JsonOptionsBean> options;
    private String message;

    public JsonOptionsResponse(String result, List<JsonOptionsBean> options) {
        this.result = result;
        this.options = options;
    }

    public JsonOptionsResponse(String result, String message) {
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

    @JsonProperty("Options")
    public List<JsonOptionsBean> getOptions() {
        return options;
    }

    public void setOptions(List<JsonOptionsBean> options) {
        this.options = options;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
