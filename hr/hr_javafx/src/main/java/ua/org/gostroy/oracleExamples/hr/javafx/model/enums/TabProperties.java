package ua.org.gostroy.oracleExamples.hr.javafx.model.enums;

/**
 * Created by Panov Sergey on 11/16/2014.
 */
public enum TabProperties {

    DEPARTMENT ("tab/Department.fxml", "Department"),
    EMPLOYEE ("tab/Employee.fxml", "Employee");

    public final String resource;
    public final String title;

    private TabProperties(String resource, String title) {
        this.resource = resource;
        this.title = title;
    }
}
