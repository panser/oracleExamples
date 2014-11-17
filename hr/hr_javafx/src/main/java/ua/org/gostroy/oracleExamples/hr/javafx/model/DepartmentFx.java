package ua.org.gostroy.oracleExamples.hr.javafx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

/**
 * Created by Panov Sergey on 11/17/2014.
 */
public class DepartmentFx {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty manager = new SimpleStringProperty();
    private final StringProperty location = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getManager() {
        return manager.get();
    }

    public StringProperty managerProperty() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager.set(manager);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public DepartmentFx() {
    }

    public DepartmentFx(Department department) {
        this.setId(department.getId());
        this.setName(department.getName());
        String manager = (department.getManager() != null) ? department.getManager().getFirstName() : "";
        String location = (department.getLocation() != null) ? department.getLocation().getCity() : "";
        this.setManager(manager);
        this.setLocation(location);
    }

}
