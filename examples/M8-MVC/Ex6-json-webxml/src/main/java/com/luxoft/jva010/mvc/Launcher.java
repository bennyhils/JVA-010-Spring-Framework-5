package com.luxoft.jva010.mvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class Launcher implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext servletContext)
    {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.scan("com.luxoft.jva010");

        DispatcherServlet servlet = new DispatcherServlet(appContext);
        ServletRegistration.Dynamic registration =
                servletContext.addServlet("dispatcher", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
