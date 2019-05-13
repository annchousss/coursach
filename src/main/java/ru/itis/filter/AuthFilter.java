package ru.itis.filter;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.repositories.AuthRepositoryHibernateImpl;

import ru.itis.repositories.AuthRepositoryImpl;
import ru.itis.services.AuthService;
import ru.itis.services.AuthServiceImpl;
import ru.itis.services.UsersService;
import ru.itis.services.UsersServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthFilter implements Filter {

    private AuthService service;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setPassword("annatugb17");
        dataSource.setUsername("postgres");
        dataSource.setUrl("jdbc:postgresql://localhost:5434/hb_ex");
        dataSource.setDriverClassName("org.postgresql.Driver");
        service = new AuthServiceImpl(new AuthRepositoryImpl(dataSource));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        Cookie cookies[] = request.getCookies();

        boolean exists = false;

        if (cookies == null) {
            cookies = new Cookie[0];
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("auth")) {
                if (!service.isExistByCookie(cookie.getValue())) {
                    response.sendRedirect("/signIn");
                    return;
                } else {
                    exists = true;
                }
            }
        }
        if (!exists) {
            response.sendRedirect("/signIn");
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}

