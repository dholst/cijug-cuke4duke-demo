package net.cijug.demo.soccer.cukes;

import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class ApplicationContextFactory {
    private static XmlWebApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = new XmlWebApplicationContext();
            applicationContext.setServletContext(new MockServletContext());
            applicationContext.setConfigLocation("classpath:applicationContext.xml");
            applicationContext.refresh();
        }

        return applicationContext;
    }
}
