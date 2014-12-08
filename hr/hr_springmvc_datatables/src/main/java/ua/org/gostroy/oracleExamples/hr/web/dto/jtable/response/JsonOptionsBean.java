package ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
public class JsonOptionsBean {

    private Integer id;
    private Object displayText;

    @JsonProperty("Value")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("DisplayText")
    public Object getDisplayText() {
        return displayText;
    }

    public void setDisplayText(Object displayText) {
        this.displayText = displayText;
    }

}
