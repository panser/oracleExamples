package ua.org.gostroy.oracleExamples.hr.javafx.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.javafx.util.SpringContextUtil;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import java.util.List;

/**
 * Created by Panov Sergey on 11/16/2014.
 */
@Service
@Transactional
public class DepartmentService{

    @Autowired
    DepartmentDao departmentDao;

    @Transactional(readOnly = true)
    public Department findById(Integer id) {
        Department result = departmentDao.findById(id);
        return result;
    }

    @Transactional(readOnly = true)
    public List<Department> findAll() {
        List<Department> result = departmentDao.findAll();
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public Department save(Department entity) throws DataIntegrityViolationException {
        Department result = departmentDao.save(entity);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public Department update(Department entity) throws DataIntegrityViolationException {
        Department result = departmentDao.update(entity);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Department entity) {
        departmentDao.delete(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        Department entity = findById(id);
        departmentDao.delete(entity);
    }
}
