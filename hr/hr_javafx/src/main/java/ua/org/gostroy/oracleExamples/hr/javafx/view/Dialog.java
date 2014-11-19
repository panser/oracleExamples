package ua.org.gostroy.oracleExamples.hr.javafx.view;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ua.org.gostroy.oracleExamples.hr.javafx.controller.DialogController;

import java.io.IOException;
import java.net.URL;
import java.util.function.Consumer;

/**
 * Created by Panov Sergey on 11/17/2014.
 */
public class Dialog extends Stage {

    private static final int OK_BUTTON = 1;
    private static final int CANCEL_BUTTON = 2;

    private int returnValue;
    private DialogController controller;

    public static <T> Object showDialog(URL resource, T userData) {
        Dialog dialog = new Dialog(resource);
        dialog.initUserData(userData);
        dialog.showAndWait();
        return dialog.controller.getUserData();
    }

    public static void executeDialog(URL resource, Object userData, Consumer callback) {
        Dialog dialog = new Dialog(resource);
        dialog.initUserData(userData);
        dialog.setCallback(callback);
        dialog.showAndWait();
    }

    public static boolean confirmation(String title, String message) {
        Dialog dialog = new Dialog();
        Button okButton = new Button("OK");
        okButton.setDefaultButton(true);
        okButton.setOnAction(value -> dialog.closeWithReturn(OK_BUTTON));
        Button cancelButton = new Button("Отмена");
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(value -> dialog.closeWithReturn(CANCEL_BUTTON));
        HBox hbox = new HBox(14, cancelButton, okButton);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        VBox vbox = new VBox(14, new Label(message), hbox);
        vbox.setPadding(new Insets(14));
        vbox.setMinWidth(300);
        Scene scene = new Scene(vbox);
        dialog.setScene(scene);
        dialog.setTitle(title);
        dialog.showAndWait();
        return dialog.returnValue == OK_BUTTON;
    }

    public static void showText(String title, String text) {
        Dialog dialog = new Dialog();
        Button okButton = new Button("OK");
        okButton.setDefaultButton(true);
        okButton.setOnAction(value -> dialog.close());
        HBox hbox = new HBox(14, okButton);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        TextArea area = new TextArea(text);
        area.setPrefColumnCount(80);
        area.setPrefRowCount(40);
        area.setWrapText(true);
        VBox vbox = new VBox(14, area, hbox);
        vbox.setPadding(new Insets(14));
        vbox.setMinWidth(300);
        Scene scene = new Scene(vbox);
        dialog.setScene(scene);
        dialog.setTitle(title);
        dialog.showAndWait();
    }

    public Dialog() {
        initModality(Modality.APPLICATION_MODAL);
    }

    public Dialog(URL resource) {
        this();
        try {
            load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(URL resource) throws IOException {
        FXMLLoader loader = new FXMLLoader(resource);
        AnchorPane pane = (AnchorPane) loader.load();
        controller = loader.getController();
        controller.setDialogStage(this);
        setScene(new Scene(pane));
    }

    public void initUserData(Object userData) {
        controller.initUserData(userData);
    }

    public void setCallback(Consumer callback) {
        controller.setCallback(callback);
    }

    private void closeWithReturn(int returnValue) {
        this.returnValue = returnValue;
        close();
    }

}
