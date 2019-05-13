package ru.itis.app;

        import org.springframework.web.WebApplicationInitializer;
        import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
        import org.springframework.web.servlet.DispatcherServlet;
        import ru.itis.config.AppConfig;
        import ru.itis.filter.AuthFilter;
        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        context.setServletContext(container);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        container.addFilter("logFilter", AuthFilter.class).addMappingForUrlPatterns(null, false, "/logOut", "/shop", "/order", "/sendorder", "/sendAddress", "/getOrder", "/insertfeed", "/categories", "/categoriesId", "/deleteOrder", "/deleteAllProducts");
    }
}