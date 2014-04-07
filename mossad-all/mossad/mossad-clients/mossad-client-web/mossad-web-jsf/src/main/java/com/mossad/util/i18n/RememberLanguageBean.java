/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.util.i18n;

import com.mossad.util.cookies.CookiesOperations;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Cookie;

/**
 * 
 * @author Buba
 */
@ManagedBean(name = "rememberLanguageBean")
@SessionScoped
public class RememberLanguageBean extends CookiesOperations implements Serializable {

    private String language = "";
    private static final String LANGUAGE_COOKIE_NAME = "i18nMSDLanguageCookie";

    public RememberLanguageBean() {
        checkLanguageCookie();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Saves selected language to cookie.
     * @param language Language String
     */
    public void saveLanguageToCookie(String language) {
        saveStringToCookie(LANGUAGE_COOKIE_NAME, language);
    }

    /**
     * Deletes language cookie.
     */
    public void deleteLanguageCookie() {
        deleteCookie(LANGUAGE_COOKIE_NAME);
    }

    private void checkLanguageCookie() {
        Cookie cookie = getCookieByName(LANGUAGE_COOKIE_NAME);

        if (cookie != null) {
            language = cookie.getValue();
        }
    }
}
