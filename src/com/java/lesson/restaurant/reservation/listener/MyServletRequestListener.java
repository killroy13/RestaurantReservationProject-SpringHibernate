package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by User on 09.03.2018.
 */
public class MyServletRequestListener implements ServletRequestListener {
    public MyServletRequestListener() {
        System.out.println(">> MyServletRequestListener - NEW");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println(">> ServletRequest - created, contextPath= " + servletRequestEvent.getServletRequest());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println(">> ServletRequest - destroyed, contextPath= " + servletRequestEvent.getServletRequest());
    }
}
