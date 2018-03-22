package com.java.lesson.restaurant.reservation.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by UserDto on 08.03.2018.
 * @author Igor Iv.
 */
public class RequestInfoFilter extends BaseFilter{

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String method = request.getMethod();
        String remoteAddr = request.getRemoteAddr();
        String queryString = request.getQueryString();
        String protocol = request.getProtocol();
        System.out.println(">> RequestInfoFilter:" + "\n method='" + method+ "'\n remoteAddr='" + remoteAddr + "'\n queryString='" + queryString + "'\n protocol='" + protocol + "'");
        System.out.println();

        chain.doFilter(request, response);
        //выполняется по возвращении
//        System.out.println("Back RequestInfoFilter");
    }

}
