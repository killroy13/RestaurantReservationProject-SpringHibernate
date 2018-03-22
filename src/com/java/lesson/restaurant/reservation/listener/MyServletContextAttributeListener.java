package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Created by UserDto on 09.03.2018.
 * @author Igor Iv.
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    public MyServletContextAttributeListener(){
        System.out.println(">> MyServletContextAttributeListener - NEW");
    }
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(">> MyServletContextAttributeListener - attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(">> MyServletContextAttributeListener - attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(">> MyServletContextAttributeListener - attributeReplaced");
    }
}
