package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by UserDto on 09.03.2018.
 * @author Igor Iv.
 */
public class SessionBindingListener implements HttpSessionBindingListener {
    public SessionBindingListener(){
        System.out.println(">> SessionBindingListener - NEW");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> SessionBinding - bound - " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">> SessionBindingListener - unbound - " + httpSessionBindingEvent.getValue());
    }
}
