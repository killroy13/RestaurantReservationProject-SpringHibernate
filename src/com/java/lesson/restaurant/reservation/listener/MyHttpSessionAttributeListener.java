package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by User on 09.03.2018.
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    public MyHttpSessionAttributeListener(){
        System.out.println(">> MyHttpSessionAttributeListener - NEW");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> SessionAttribute - added - " + httpSessionBindingEvent.getSession().getAttributeNames());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> SessionAttribute - removed - " + httpSessionBindingEvent.getSession().getAttributeNames());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> SessionAttribute - replaced - " + httpSessionBindingEvent.getSession().getAttributeNames());
    }
}
