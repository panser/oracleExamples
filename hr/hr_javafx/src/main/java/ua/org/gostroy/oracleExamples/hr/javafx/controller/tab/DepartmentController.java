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
import ua.org.gostroy.oracleExamples.hr.javafx.service.DepartmentService;
import ua.org.gostroy.oracleExamples.hr.javafx.util.SpringContextUtil;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

/**
 * Created by Panov Sergey on 11/16/2014.
 */
public class DepartmentController {
    public TableView departmentTable;
    public TableColumn departmentName;
    public TableColumn departmentManager;
    public TableColumn departmentLocation;
    public Label departmentNameLabel;
    public TableView EmployeeTable;
    public TableColumn employeeName;

//    @Autowired
    DepartmentService departmentService;

    @FXML
    public void initialize(){
        departmentService = (DepartmentService) SpringContextUtil.getBean("departmentService");
        departmentName.setCellFactory(new PropertyValueFactory<Department, String>("name"));
        departmentTable.setItems(getObservableList());
    }

    protected ObservableList getObservableList() {
        return FXCollections.observableArrayList(departmentService.findAll());
    }
}
