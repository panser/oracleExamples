package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import com.github.dandelion.core.utils.StringUtils;
import com.github.dandelion.datatables.core.ajax.ColumnDef;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Panov Sergey on 11/8/2014.
 */
public class DepartmentOverDatatablesUtils {

    /**
     *
     * @param select
     * @param criterias
     * @return
     */
    public static StringBuilder getFilterQuery(DatatablesCriterias criterias){
        StringBuilder queryBuilder = new StringBuilder();
        List<String> paramList = new ArrayList<String>();

        /**
         * Step 1.1: global filtering
         */
        if (StringUtils.isNotBlank(criterias.getSearch()) && criterias.hasOneFilterableColumn()) {
            queryBuilder.append(" WHERE ");

            for (ColumnDef columnDef : criterias.getColumnDefs()) {
                if (columnDef.isFilterable() && StringUtils.isBlank(columnDef.getSearch())) {
                    paramList.add(" LOWER(p." + columnDef.getName()
                            + ") LIKE '%?%'".replace("?", criterias.getSearch().toLowerCase()));
                }
            }

            Iterator<String> itr = paramList.iterator();
            while (itr.hasNext()) {
                queryBuilder.append(itr.next());
                if (itr.hasNext()) {
                    queryBuilder.append(" OR ");
                }
            }
        }

        /**
         * Step 1.2: individual column filtering
         */
        if (criterias.hasOneFilterableColumn() && criterias.hasOneFilteredColumn()) {
            paramList = new ArrayList<String>();

            if(!queryBuilder.toString().contains("WHERE")){
                queryBuilder.append(" WHERE ");
            }
            else{
                queryBuilder.append(" AND ");
            }

            for (ColumnDef columnDef : criterias.getColumnDefs()) {
                if (columnDef.isFilterable()){
                    if (StringUtils.isNotBlank(columnDef.getSearchFrom())) {
                        if (columnDef.getName().equalsIgnoreCase("birthDate")) {
                            paramList.add("p." + columnDef.getName() + " >= '" + columnDef.getSearchFrom() + "'");
                        }
                        else {
                            paramList.add("p." + columnDef.getName() + " >= " + columnDef.getSearchFrom());
                        }
                    }

                    if (StringUtils.isNotBlank(columnDef.getSearchTo())) {
                        if (columnDef.getName().equalsIgnoreCase("birthDate")) {
                            paramList.add("p." + columnDef.getName() + " < '" + columnDef.getSearchTo() + "'");
                        }
                        else {
                            paramList.add("p." + columnDef.getName() + " < " + columnDef.getSearchTo());
                        }
                    }

                    if(StringUtils.isNotBlank(columnDef.getSearch())) {
                        paramList.add(" LOWER(p." + columnDef.getName()
                                + ") LIKE '%?%'".replace("?", columnDef.getSearch().toLowerCase()));
                    }
                }
            }

            Iterator<String> itr = paramList.iterator();
            while (itr.hasNext()) {
                queryBuilder.append(itr.next());
                if (itr.hasNext()) {
                    queryBuilder.append(" AND ");
                }
            }
        }

        return queryBuilder;
    }

}
