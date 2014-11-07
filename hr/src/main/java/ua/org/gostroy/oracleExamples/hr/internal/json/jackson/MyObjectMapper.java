package ua.org.gostroy.oracleExamples.hr.internal.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/**
 * Created by Panov Sergey on 11/7/2014.
 */
public class MyObjectMapper extends ObjectMapper {
    public MyObjectMapper() {
        registerModule(new Hibernate4Module());
        registerModule(new JaxbAnnotationModule());
    }
}
