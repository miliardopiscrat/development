package com.mossad.login;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  This filter is meant to prevent already logged in users from accessing the log in page.
 * 
 * @author Piotr Babij
 */
public class AlreadyLoggedInFilter implements Filter {

    public static final String TARGET_PARAMETER_NAME = "target";
    /**
     * Logged in users are redirected to this page
     */
    private String target;

    @Override
    public void init(FilterConfig fc) throws ServletException {
        target = fc.getInitParameter(TARGET_PARAMETER_NAME);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        final HttpServletRequest r = (HttpServletRequest) request;
        final String remoteUser = r.getRemoteUser();
        final String authType = r.getAuthType();
        final Principal userPrincipal = r.getUserPrincipal();
        
        if (remoteUser != null || authType != null || userPrincipal != null) {
            ((HttpServletResponse) response).sendRedirect(target);
        } else {
            fc.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
