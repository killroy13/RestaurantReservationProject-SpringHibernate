package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by User on 09.03.2018.
 */
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {
    public MyHttpSessionBindingListener(){
        System.out.println(">> MyHttpSessionBindingListener - NEW");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> SessionBinding - bound - " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> MyHttpSessionBindingListener - unbound - " + httpSessionBindingEvent.getValue());
    }
}
