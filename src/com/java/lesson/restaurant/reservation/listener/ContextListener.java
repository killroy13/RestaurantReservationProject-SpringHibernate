package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by UserDto on 09.03.2018.
 * @author Igor Iv.
 */
public class ContextListener implements ServletContextListener {
    public ContextListener() {
        System.out.println(">> ContextListener - NEW");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(">> ServletContext - created, contextPath" + servletContextEvent.getServletContext().getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(">> ServletContext - destroyed, contextPath" + servletContextEvent.getServletContext().getContextPath());
    }
}
