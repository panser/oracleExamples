package ua.org.gostroy.oracleExamples.hr.javafx.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Panov Sergey on 11/16/2014.
 */
public class SpringContextUtil {
    private static ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }
}
