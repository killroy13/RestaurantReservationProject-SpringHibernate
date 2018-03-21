package com.java.lesson.restaurant.reservation.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Created by User on 09.03.2018.
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
    public MyHttpSessionActivationListener(){
        System.out.println(">> MyHttpSessionActivationListener - NEW");
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
