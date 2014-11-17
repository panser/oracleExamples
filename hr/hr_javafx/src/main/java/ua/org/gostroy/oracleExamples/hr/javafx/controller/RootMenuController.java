package ua.org.gostroy.oracleExamples.hr.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import ua.org.gostroy.oracleExamples.hr.javafx.model.enums.TabProperties;

import java.util.function.Consumer;

/**
 * Created by Panov Sergey on 11/16/2014.
 */
public class RootMenuController {

    @FXML
    private Consumer<TabProperties> parentController;

    public void setConsumer(Consumer<TabProperties> parentController) {
        this.parentController = parentController;
    }

    public void handleAction(ActionEvent actionEvent) {
        MenuItem menu = (MenuItem) actionEvent.getSource();
        TabProperties tab = TabProperties.valueOf(menu.getId());
        parentController.accept(tab);
    }
}
