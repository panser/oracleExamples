package ua.org.gostroy.oracleExamples.hr.dao.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.dao.jpa.DepartmentImpl;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Panov Sergey on 11/19/2014.
 */
public class DepartmentMockDaoTest {

    private Integer testDepartmentId = 20;
    @InjectMocks
    private DepartmentImpl departmentImpl = new DepartmentImpl();

    @Mock
    private EntityManager em;
    @Mock
    private Query query;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findById(){
        Department department = new Department();
        department.setId(testDepartmentId);
        when(em.find(Department.class, testDepartmentId)).thenReturn(department);

        Department test = departmentImpl.findById(testDepartmentId);

        assertEquals(test.getId(), testDepartmentId);
        assertThat(test.getId(), is(testDepartmentId));
    }

    @Test
    public void findAll(){
        Department department = new Department();
        department.setId(testDepartmentId);
        List<Department> departments = new ArrayList<>();
        departments.add(department);
        when(em.createNamedQuery(anyString())).thenReturn(query);
//        when(em.createNamedQuery("Department.findAll")).thenReturn(query);
        when(query.getResultList()).thenReturn(departments);

        List<Department> countries = departmentImpl.findAll();

        assertNotEquals(countries.size(), 0);
        assertThat(countries.get(0).getId(), is(testDepartmentId));
    }

    @Test
    public void save(){
        Department test = new Department("TEST");
        when(em.merge(test)).thenReturn(test);

        Department testNew = departmentImpl.save(test);

        assertThat(testNew.getName(), is("TEST"));

    }
}
