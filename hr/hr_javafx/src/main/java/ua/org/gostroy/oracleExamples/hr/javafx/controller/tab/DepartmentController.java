package ua.org.gostroy.oracleExamples.hr.javafx.controller.tab;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.javafx.model.DepartmentFx;
import ua.org.gostroy.oracleExamples.hr.javafx.model.EmployeeFx;
import ua.org.gostroy.oracleExamples.hr.javafx.service.DepartmentService;
import ua.org.gostroy.oracleExamples.hr.javafx.service.EmployeeService;
import ua.org.gostroy.oracleExamples.hr.javafx.util.SpringContextUtil;
import ua.org.gostroy.oracleExamples.hr.javafx.view.Dialog;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

import javax.persistence.StoredProcedureQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Panov Sergey on 11/16/2014.
 */
public class DepartmentController {
    @FXML
    private TableView<Department> departmentTable;
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
        departmentId.setCellValueFactory(new PropertyValueFactory<Department, Integer>("id"));
        departmentName.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
//        departmentManager.setCellValueFactory(new PropertyValueFactory<DepartmentFx, Integer>("manager"));
//        departmentLocation.setCellValueFactory(new PropertyValueFactory<DepartmentFx, Object>("location"));
//                http://code.makery.ch/blog/javafx-8-tableview-cell-renderer/
//        departmentLocation.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
/*
        departmentLocation.setCellFactory(column -> {
            return new TableCell<Department, Location>(){
                @Override
                protected void updateItem(Location item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item != null ? item.getCity() : "");
                }
            };
        });
*/
        departmentLocation.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Department, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Department, String> p) {
                if (p.getValue().getLocation() != null) {
                    return new SimpleStringProperty(p.getValue().getLocation().getCity());
                } else {
                    return new SimpleStringProperty("<no name>");
                }
            }
        });


        departmentTable.setItems(FXCollections.observableArrayList(departmentService.findAll()));
/*
        departmentTable.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<DepartmentFx>() {
                    public void changed(ObservableValue<? extends DepartmentFx> observable, DepartmentFx oldValue, DepartmentFx newValue) {
                        showPhonePrefixDetails(newValue);
                    }
                });
*/
        departmentTable.getSelectionModel().selectFirst();
    }

    private void showPhonePrefixDetails(DepartmentFx departmentFx) {
        departmentNameLabel.setText(departmentFx.getName());
        employeeName.setCellValueFactory(new PropertyValueFactory<EmployeeFx, Object>("firstName"));
        employeeTable.setItems(FXCollections.observableArrayList(departmentService.findEmployeeFxById(departmentFx.getId())));
//        employeeTable.setItems(FXCollections.observableArrayList(employeeService.findByDepartment(departmentFx.getId())));
    }

    @FXML
    private void addDepartment(ActionEvent actionEvent) {

    }

    @FXML
    private void editDepartment(ActionEvent actionEvent) {
        if (departmentTable.getSelectionModel().isEmpty()) return;
        Map params = new HashMap();
        params.put("department", departmentTable.getSelectionModel().getSelectedItems());
        Dialog.executeDialog(getClass().getResource("DepartmentEdit.fxml"), params, this::editDepartment);
    }

    private void editDepartment(Object userData) {
        Map result = (Map) userData;
        System.out.println();
//        ObservableList<TariffPlan> tariffPlans = tariffPlanTable.getSelectionModel().getSelectedItems();
//        String counterCode = (String) result.get("counterCode");
//        BillingService service = (BillingService) result.get("service");
//        Date dateStart = (Date) result.get("dateStart");
//        String function = (String) result.get("function");
//        Processor processor = ProcessorFactory.createProcessor();
//        processor.addCounter(counterCode, service, tariffPlans, dateStart, function);
    }
}
