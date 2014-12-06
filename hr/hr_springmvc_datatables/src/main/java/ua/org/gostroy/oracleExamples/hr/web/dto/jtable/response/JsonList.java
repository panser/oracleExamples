package ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.bean.JtableDepartment;

import java.util.List;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
public class JsonList<T> {

    private String result;
    private List<T> records;
    private int totalRecordCount;
    private String message;

    public JsonList(String result, List<T> records, int totalRecordCount) {
        this.result = result;
        this.records = records;
        this.totalRecordCount = totalRecordCount;
    }

    public JsonList(String result, String message) {
        this.result = result;
        this.message = message;
    }

    @JsonProperty("Result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        result = result;
    }

    @JsonProperty("Records")
    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<JtableDepartment> records) {
        records = records;
    }

    @JsonProperty("TotalRecordCount")
    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        totalRecordCount = totalRecordCount;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        message = message;
    }
}
