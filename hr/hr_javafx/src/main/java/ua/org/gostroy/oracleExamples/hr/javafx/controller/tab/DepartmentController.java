package ua.org.gostroy.oracleExamples.hr.javafx.controller.tab;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import ua.org.gostroy.oracleExamples.hr.javafx.model.EmployeeFx;
import ua.org.gostroy.oracleExamples.hr.javafx.service.DepartmentService;
import ua.org.gostroy.oracleExamples.hr.javafx.service.EmployeeService;
import ua.org.gostroy.oracleExamples.hr.javafx.util.SpringContextUtil;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import javax.persistence.StoredProcedureQuery;
import java.util.Objects;

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
    private TableView<EmployeeFx> employeeTable;
    @FXML
    private TableColumn employeeName;

    DepartmentService departmentService;
    EmployeeService employeeService;

    @FXML
    private void initialize(){
        departmentService = (DepartmentService) SpringContextUtil.getBean("departmentService");
        employeeService = (EmployeeService) SpringContextUtil.getBean("employeeService");
        departmentId.setCellValueFactory(new PropertyValueFactory<DepartmentFx, Integer>("id"));
        departmentName.setCellValueFactory(new PropertyValueFactory<DepartmentFx, String>("name"));
        departmentManager.setCellValueFactory(new PropertyValueFactory<DepartmentFx, Integer>("manager"));
        departmentLocation.setCellValueFactory(new PropertyValueFactory<DepartmentFx, Object>("location"));
        departmentTable.setItems(FXCollections.observableArrayList(departmentService.findAll()));
        departmentTable.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<DepartmentFx>() {
                    public void changed(ObservableValue<? extends DepartmentFx> observable, DepartmentFx oldValue, DepartmentFx newValue) {
                        showPhonePrefixDetails(newValue);
                    }
                });
    }

    private void showPhonePrefixDetails(DepartmentFx departmentFx) {
        departmentNameLabel.setText(departmentFx.getName());
        employeeName.setCellValueFactory(new PropertyValueFactory<EmployeeFx, Object>("firstName"));
        employeeTable.setItems(FXCollections.observableArrayList(departmentService.findEmployeeFxById(departmentFx.getId())));
//        employeeTable.setItems(FXCollections.observableArrayList(employeeService.findByDepartment(departmentFx.getId())));
    }
}
