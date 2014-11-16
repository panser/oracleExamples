package ua.org.gostroy.oracleExamples.hr.javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ua.org.gostroy.oracleExamples.hr.javafx.model.TabProperties;

import java.io.IOException;

/**
 * Created by Panov Sergey on 11/16/2014.
 */
public class RootLayoutController {
    public TabPane tabPane;
    public RootMenuController rootMenuController;

    @FXML
    private void initialize(){
        rootMenuController.setConsumer(tab -> openPaneAsTab(tab));
    }

    private void openPaneAsTab(TabProperties tabProperties){
        for (Tab existingTab : tabPane.getTabs()) {
            if (existingTab.getId().equals(tabProperties.toString())) {
                tabPane.getSelectionModel().select(existingTab);
                return;
            }
        }
        try {
            Pane pane = (AnchorPane) FXMLLoader.load(getClass().getResource(tabProperties.resource));
            Tab tab = new Tab();
            tab.setId(tabProperties.toString());
            tab.setText(tabProperties.title);
            tab.setContent(pane);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().selectLast();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
