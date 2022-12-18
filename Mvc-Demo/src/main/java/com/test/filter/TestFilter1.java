package com.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class TestFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TestFilter1 doFilter enter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("TestFilter1 doFilter end");
    }

    @Override
    public void destroy() {

    }
}
