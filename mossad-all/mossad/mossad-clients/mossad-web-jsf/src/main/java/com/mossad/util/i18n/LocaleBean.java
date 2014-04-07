/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.util.i18n;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * This bean stores the information about locale of current user.
 * 
 * @author Piotr Babij
 */
@ManagedBean(name = "localeBean")
@SessionScoped
public class LocaleBean implements Serializable {

    private Locale locale;
    private Map<String, Locale> supportedLocalesMap;
    private List<Locale> supportedLocales;
    private boolean localeChanged;
    @ManagedProperty("#{rememberLanguageBean}")
    private RememberLanguageBean rememberLanguageBean;

    public LocaleBean() {
        final FacesContext ctx = FacesContext.getCurrentInstance();

        locale = ctx.getViewRoot().getLocale();

        supportedLocalesMap = new HashMap<String, Locale>();

        supportedLocales = new ArrayList<Locale>();
        Iterator<Locale> i = ctx.getApplication().getSupportedLocales();
        while (i.hasNext()) {
            Locale l = i.next();
            supportedLocales.add(l);
            supportedLocalesMap.put(toLocaleString(l), l);
        }
        Collections.sort(supportedLocales, new Comparator<Locale>() {

            @Override
            public int compare(Locale o1, Locale o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }

    private String toLocaleString(Locale l) {
        return l.getLanguage() + "_" + l.getCountry();
    }

    public RememberLanguageBean getRememberLanguageBean() {
        return rememberLanguageBean;
    }

    public void setRememberLanguageBean(RememberLanguageBean rememberLanguageBean) {
        this.rememberLanguageBean = rememberLanguageBean;
    }

    public Map<String, Locale> getSupportedLocalesMap() {
        return supportedLocalesMap;
    }

    public void setSupportedLocalesMap(Map<String, Locale> supportedLocalesMap) {
        this.supportedLocalesMap = supportedLocalesMap;
    }

    public Locale getLocale() {
        if (!localeChanged) {
            final String language = rememberLanguageBean.getLanguage();
            if (language != null && !language.isEmpty()) {
                locale = supportedLocalesMap.get(language);
            }
        }
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        localeChanged = true;
        rememberLanguageBean.saveLanguageToCookie(toLocaleString(locale));
    }

    public List<Locale> getSupportedLocales() {
        if (supportedLocales.contains(locale)) {
            supportedLocales.remove(locale);
            supportedLocales.add(0, locale);
        }
        return supportedLocales;
    }

    public void change(ValueChangeEvent evt) {
        final Locale l = supportedLocalesMap.get(evt.getNewValue().toString());
        if (l != null) {
            setLocale(l);
        }

    }
}
