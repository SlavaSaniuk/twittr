package by.bsac.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 *
 */
public class WebApplicationRunner implements WebApplicationInitializer {

    /** Class global variables */


    /** Class methods */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //Create "Root" application context
        {
            AnnotationConfigWebApplicationContext root_context =
                    new AnnotationConfigWebApplicationContext();

            //Register configuration class:
            root_context.register(RootConfiguration.class);

            //Set active profiles:
            root_context.getEnvironment().setActiveProfiles("production");

        }

        //Create "Servlet" application context
        {
            AnnotationConfigWebApplicationContext servlet_context =
                    new AnnotationConfigWebApplicationContext();

            //Register configuration class:
            servlet_context.register(WebConfiguration.class);

            //Set servlet context
            servlet_context.setServletContext(servletContext);

            //Register Dispatcher Servlet
            ServletRegistration.Dynamic dispatcher_servlet = servletContext.addServlet("dispatcher_servlet", new DispatcherServlet(servlet_context));

                //Set parameters to Dispatcher servlet
                {
                    dispatcher_servlet.addMapping("/");
                    dispatcher_servlet.setLoadOnStartup(1);
                }
        }



    }






}
