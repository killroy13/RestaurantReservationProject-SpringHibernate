package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Created by UserDto on 09.03.2018.
 * @author Igor Iv.
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener{

    public MyServletRequestAttributeListener(){
        System.out.println(">> MyServletRequestAttributeListener - NEW");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }
}
