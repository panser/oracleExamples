package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.EmpDetailsViewDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.EmpDetailsView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Panov Sergey on 11/4/2014.
 */
@Repository(value = "empDetailsViewDao")
public class EmpDetailsViewImpl implements EmpDetailsViewDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EmpDetailsView> findAll() {
        Query query = em.createNamedQuery("EmpDetailsView.findAll");
        List<EmpDetailsView> empDetailsViews = (List<EmpDetailsView>) query.getResultList();
        return empDetailsViews;
    }

    @Override
    public List<EmpDetailsView> findByEmployeeId(Integer employeeId) {
        Query query = em.createNamedQuery("EmpDetailsView.findByEmployeeId");
        query.setParameter("employeeId", employeeId);
        List<EmpDetailsView> empDetailsViewList = (List<EmpDetailsView>) query.getResultList();
        return empDetailsViewList;
    }

    @Override
    public List<EmpDetailsView> findByJobId(String jobId) {
        Query query = em.createNamedQuery("EmpDetailsView.findByJobId");
        query.setParameter("jobId", jobId);
        List<EmpDetailsView> empDetailsViewList = (List<EmpDetailsView>) query.getResultList();
        return empDetailsViewList;
    }
}
