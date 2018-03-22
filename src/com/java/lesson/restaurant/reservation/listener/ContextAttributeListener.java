package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Created by UserDto on 09.03.2018.
 * @author Igor Iv.
 */
public class ContextAttributeListener implements ServletContextAttributeListener {
    public ContextAttributeListener(){
        System.out.println(">> ContextAttributeListener - NEW");
    }
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(">> ContextAttributeListener - attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(">> ContextAttributeListener - attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(">> ContextAttributeListener - attributeReplaced");
    }
}
