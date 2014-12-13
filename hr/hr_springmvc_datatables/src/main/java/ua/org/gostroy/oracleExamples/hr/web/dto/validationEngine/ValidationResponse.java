package ua.org.gostroy.oracleExamples.hr.web.dto.validationEngine;

/**
 * Created by Panov Sergey on 12/13/2014.
 */
public class ValidationResponse {

    private String fieldId;
    private Boolean status;
    private String errorMsg;

    public ValidationResponse() {
    }

    public ValidationResponse(String fieldId, Boolean status, String errorMsg) {
        this.fieldId = fieldId;
        this.status = status;
        this.errorMsg = errorMsg;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String asAnswer() {
        return "[[\"" + fieldId + "\"," + status + ",\"" + errorMsg + "\"]]";
    }
}
