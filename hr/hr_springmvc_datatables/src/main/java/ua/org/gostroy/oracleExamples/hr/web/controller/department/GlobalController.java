package ua.org.gostroy.oracleExamples.hr.web.controller.department;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.gostroy.oracleExamples.hr.model.JsonError;
import ua.org.gostroy.oracleExamples.hr.model.MessageError;

/**
 * Created by Panov Sergey on 11/10/2014.
 */
@ControllerAdvice
public class GlobalController {

    @ExceptionHandler({JpaSystemException.class, DataIntegrityViolationException.class})
    @ResponseBody
    public JsonError handleJpaException(Exception e) {
        MessageError messageError = new MessageError(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR.value());
        JsonError jsonError = new JsonError(messageError);
        return jsonError;
    }

}
