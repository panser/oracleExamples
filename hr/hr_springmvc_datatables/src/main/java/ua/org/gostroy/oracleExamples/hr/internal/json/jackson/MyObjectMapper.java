package ua.org.gostroy.oracleExamples.hr.internal.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/**
 * Created by Panov Sergey on 11/7/2014.
 */
public class MyObjectMapper extends ObjectMapper {
    public MyObjectMapper() {
        Hibernate4Module hbm = new Hibernate4Module();
        hbm.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
        registerModule(hbm);

        registerModule(new JaxbAnnotationModule());

        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
