/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.util.cookies;

import java.util.Arrays;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Buba
 */
public abstract class CookiesOperations {

    public void saveStringToCookie(String cookieName, String str) {
        Cookie languageCookie = new Cookie(cookieName, str);
        //set cookie age to 1 month
        languageCookie.setMaxAge(3600 * 24 * 7 * 4);
        getResponse().addCookie(languageCookie);
    }

    public void deleteCookie(String cookieName) {
        Cookie cookie = getCookieByName(cookieName);

        //there is no straightforward way of deleting cookie
        if (cookie != null) {
            cookie.setMaxAge(0);
            cookie.setValue("");
            getResponse().addCookie(cookie);
        }
    }

    public Cookie getCookieByName(String cookieName) {
        Cookie[] cookiesArray = getRequest().getCookies();
        
        if (cookiesArray != null) {
            List<Cookie> cookiesList = Arrays.asList(cookiesArray);
            
            for (Cookie cookie : cookiesList) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    private HttpServletRequest getRequest() {
        return ((HttpServletRequest) getFacesContext().getExternalContext().getRequest());
    }

    private HttpServletResponse getResponse() {
        return (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
    }

    private FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
