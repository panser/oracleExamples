package ua.org.gostroy.oracleExamples.hr.web.dto.validationEngine;

/**
 * Created by Panov Sergey on 12/13/2014.
 */
public class ValidationRequest {
    private String fieldId;
    private String fieldValue;

    public ValidationRequest() {
    }

    public ValidationRequest(String fieldId, String fieldValue) {
        this.fieldId = fieldId;
        this.fieldValue = fieldValue;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
