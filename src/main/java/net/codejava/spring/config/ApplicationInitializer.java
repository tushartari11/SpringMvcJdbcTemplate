package net.codejava.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
    public void onStartup(ServletContext container) throws ServletException {
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(MvcConfiguration.class);
        dispatcherServlet.setServletContext(container);
        DispatcherServlet ds=  new DispatcherServlet(dispatcherServlet);
        ds.setThrowExceptionIfNoHandlerFound(true);
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", ds);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
