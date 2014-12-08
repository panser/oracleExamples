package ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
public class JsonOptionsBean {

    private Integer id;
    private String displayText;

    public JsonOptionsBean() {
    }

    public JsonOptionsBean(Integer id, String displayText) {
        this.id = id;
        this.displayText = displayText;
    }

    @JsonProperty("Value")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("DisplayText")
    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

}
