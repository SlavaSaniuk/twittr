package by.bsac.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 *  WebApplicationRunner class start web application.
 *  Define application context and them child web application context.
 *  Create and set Dispatcher Servlet.
 */
public class WebApplicationRunner implements WebApplicationInitializer {

    /* Class methods */
    /**
     * Method is called on application startup.
     * Manually create application context (Root context) and child web application context (Web context),
     * for specifying "DispatcherServlet" and other servlets.
     * @param servletContext - Servlet context for Web context.
     * @throws ServletException - In Servlet context is not created automatically.
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //Create "Root" application context
        AnnotationConfigApplicationContext root_context =
                new AnnotationConfigApplicationContext();

        //Register configuration class:
        root_context.register(RootConfiguration.class);

        //Set active profiles:
        root_context.getEnvironment().setActiveProfiles("development");

        //Create "Servlet" application context
        AnnotationConfigWebApplicationContext web_context =
                new AnnotationConfigWebApplicationContext();

        //Set root application context as parent application context:
        web_context.setParent(root_context);
        //Register configuration class:
        web_context.register(WebConfiguration.class);
        //Set servlet context:
        web_context.setServletContext(servletContext);

        //Update
        root_context.refresh();
        web_context.refresh();

        //Register Dispatcher Servlet
        ServletRegistration.Dynamic dispatcher_servlet = servletContext.addServlet("dispatcher_servlet", new DispatcherServlet(web_context));

        //Set parameters to Dispatcher servlet
        dispatcher_servlet.addMapping("/");
        dispatcher_servlet.setLoadOnStartup(1);

    }

}
