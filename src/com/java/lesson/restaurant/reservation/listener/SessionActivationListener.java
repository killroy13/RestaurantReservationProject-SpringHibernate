package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Created by UserDto on 09.03.2018.
 * @author Igor Iv.
 */
public class SessionActivationListener implements HttpSessionActivationListener {
    public SessionActivationListener(){
        System.out.println(">> SessionActivationListener - NEW");
    }
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession - will passivate, id = " + httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession - did activate, id = " + httpSessionEvent.getSession().getId());
    }
}
