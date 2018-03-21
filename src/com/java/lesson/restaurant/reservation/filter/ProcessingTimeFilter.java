package com.java.lesson.restaurant.reservation.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by User on 08.03.2018.
 */
public class ProcessingTimeFilter implements Filter {

    public ProcessingTimeFilter (){
        System.out.println(">> ProcessingTimeFilter - NEW");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">> ProcessingTimeFilter  - init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long inTime = System.nanoTime();
        filterChain.doFilter(servletRequest, servletResponse);
        long outTome = System.nanoTime();
        System.out.println(">> ProcessingTimeFilter: dT = " + (outTome - inTime));
        System.out.println();
    }

    @Override
    public void destroy() {
        System.out.println(">> ProcessingTimeFilter - destroy");
    }
}
