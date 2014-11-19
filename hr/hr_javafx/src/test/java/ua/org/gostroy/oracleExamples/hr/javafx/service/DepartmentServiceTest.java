package ua.org.gostroy.oracleExamples.hr.javafx.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Panov Sergey on 11/20/2014.
 */
public class DepartmentServiceTest {

    private Integer testDepartmentId = 20;
    private Department department = new Department();

    @InjectMocks
    private DepartmentService departmentService = new DepartmentService();

    @Mock
    private DepartmentDao departmentDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        department.setId(testDepartmentId);
    }

    @Test
    public void findById(){
        when(departmentDao.findById(testDepartmentId)).thenReturn(department);

        Department department = departmentService.findById(testDepartmentId);
        assertThat(department.getId(), is(testDepartmentId));
    }
}
