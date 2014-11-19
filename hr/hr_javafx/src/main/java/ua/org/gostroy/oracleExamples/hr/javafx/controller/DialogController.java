package ua.org.gostroy.oracleExamples.hr.javafx.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * Created by Panov Sergey on 11/17/2014.
 */
public class DialogController {

    private Stage dialogStage;
    private Consumer<Object> callback;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setCallback(Consumer callback) {
        this.callback = callback;
    }

    public void initUserData(Object userData) {
    }

    public Object getUserData() {
        return null;
    }

    @FXML
    protected final void cancel() {
        dialogStage.close();
    }

    @FXML
    protected final void ok() {
        if (callback != null) callback.accept(getUserData());
        dialogStage.close();
    }
}
