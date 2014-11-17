package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import com.github.dandelion.datatables.core.ajax.ColumnDef;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentOverDatatablesDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Panov Sergey on 11/8/2014.
 */
@Repository(value = "departmentOverDatatablesDao")
public class DepartmentOverDatatablesImpl implements DepartmentOverDatatablesDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @return the complete list of persons.
     */
    public List<Department> findAll() {
        TypedQuery<Department> query = entityManager.createQuery("SELECT p FROM Department p", Department.class);
        return query.getResultList();
    }

    /**
     * @param maxResult Max number of persons.
     * @return a maxResult limited list of persons.
     */
    public List<Department> findLimited(int maxResult) {
        TypedQuery<Department> query = entityManager.createQuery("SELECT p FROM Department p", Department.class);
        query.setMaxResults(maxResult);
        return query.getResultList();
    }

    /**
     * <p/>
     * Query used to populate the DataTables that display the list of persons.
     *
     * @param criterias The DataTables criterias used to filter the persons.
     *                  (maxResult, filtering, paging, ...)
     * @return a filtered list of persons.
     */
    public List<Department> findDepartmentWithDatatablesCriterias(DatatablesCriterias criterias) {

        StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Department p");

        /**
         * Step 1: global and individual column filtering
         */
        queryBuilder.append(DepartmentOverDatatablesUtils.getFilterQuery(criterias));

        /**
         * Step 2: sorting
         */
        if (criterias.hasOneSortedColumn()) {

            List<String> orderParams = new ArrayList<String>();
            queryBuilder.append(" ORDER BY ");
            for (ColumnDef columnDef : criterias.getSortingColumnDefs()) {
                orderParams.add("p." + columnDef.getName() + " " + columnDef.getSortDirection());
            }

            Iterator<String> itr2 = orderParams.iterator();
            while (itr2.hasNext()) {
                queryBuilder.append(itr2.next());
                if (itr2.hasNext()) {
                    queryBuilder.append(" , ");
                }
            }
        }

        TypedQuery<Department> query = entityManager.createQuery(queryBuilder.toString(), Department.class);

        /**
         * Step 3: paging
         */
        query.setFirstResult(criterias.getDisplayStart());
        query.setMaxResults(criterias.getDisplaySize());

        return query.getResultList();
    }

    /**
     * <p/>
     * Query used to return the number of filtered persons.
     *
     * @param criterias The DataTables criterias used to filter the persons.
     *                  (maxResult, filtering, paging, ...)
     * @return the number of filtered persons.
     */
    public Long getFilteredCount(DatatablesCriterias criterias) {

        StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Department p");

        queryBuilder.append(DepartmentOverDatatablesUtils.getFilterQuery(criterias));

        Query query = entityManager.createQuery(queryBuilder.toString());
        return Long.parseLong(String.valueOf(query.getResultList().size()));
    }

    /**
     * @return the total count of persons.
     */
    public Long getTotalCount() {
        Query query = entityManager.createQuery("SELECT COUNT(p) FROM Department p");
        return (Long) query.getSingleResult();
    }

}
