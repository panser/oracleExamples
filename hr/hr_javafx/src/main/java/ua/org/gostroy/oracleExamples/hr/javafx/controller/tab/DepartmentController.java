package ua.org.gostroy.oracleExamples.hr.javafx.controller.tab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.javafx.model.DepartmentFx;
import ua.org.gostroy.oracleExamples.hr.javafx.service.DepartmentService;
import ua.org.gostroy.oracleExamples.hr.javafx.util.SpringContextUtil;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

/**
 * Created by Panov Sergey on 11/16/2014.
 */
public class DepartmentController {
    @FXML
    private TableView<DepartmentFx> departmentTable;
    @FXML
    private TableColumn departmentId;
    @FXML
    private TableColumn departmentName;
    @FXML
    private TableColumn departmentManager;
    @FXML
    private TableColumn departmentLocation;
    @FXML
    private Label departmentNameLabel;
    @FXML
    private TableView EmployeeTable;
    @FXML
    private TableColumn employeeName;

    DepartmentService departmentService;

    @FXML
    private void initialize(){
        departmentService = (DepartmentService) SpringContextUtil.getBean("departmentService");
        departmentId.setCellValueFactory(new PropertyValueFactory<DepartmentFx, Integer>("id"));
        departmentName.setCellValueFactory(new PropertyValueFactory<DepartmentFx, String>("name"));
        departmentManager.setCellValueFactory(new PropertyValueFactory<DepartmentFx, Integer>("manager"));
        departmentLocation.setCellValueFactory(new PropertyValueFactory<DepartmentFx, Integer>("location"));
        departmentTable.setItems(getObservableList());
    }

    protected ObservableList getObservableList() {
        ObservableList observableList = FXCollections.observableArrayList(departmentService.findAll());
        return observableList;
    }
}
