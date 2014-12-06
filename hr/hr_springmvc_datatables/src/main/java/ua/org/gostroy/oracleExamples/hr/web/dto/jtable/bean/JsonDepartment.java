package ua.org.gostroy.oracleExamples.hr.web.dto.jtable.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
public class JsonDepartment {
    private Integer id;
    private String name;
    private String manager;
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
