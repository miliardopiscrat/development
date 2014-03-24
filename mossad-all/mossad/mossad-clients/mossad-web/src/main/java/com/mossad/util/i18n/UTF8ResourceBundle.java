package com.mossad.util.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 * Custom resource bundle that reads properties file encoded in UTF8 standard 
 * 
 * @author Piotr Babij
 */
public class UTF8ResourceBundle extends ResourceBundle {

    // this bundle expects to have messages.properties file in com/mossad/util/i18n directory
    protected static final String BUNDLE_NAME = "com.mossad.util.i18n.messages";
    protected static final String BUNDLE_EXTENSION = "properties";
    protected static final Control UTF8_CONTROL = new UTF8Control();

    public UTF8ResourceBundle() {
        setParent(ResourceBundle.getBundle(BUNDLE_NAME,
                FacesContext.getCurrentInstance().getViewRoot().getLocale(), UTF8_CONTROL));
    }

    @Override
    protected Object handleGetObject(String key) {
        return parent.getObject(key);
    }

    @Override
    public Enumeration getKeys() {
        return parent.getKeys();
    }

    protected static class UTF8Control extends Control {

        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException {
            // The below code is copied from default Control#newBundle() implementation.
            // Only the PropertyResourceBundle line is changed to read the file as UTF-8.
            String bundleName = toBundleName(baseName, locale);
            String resourceName = toResourceName(bundleName, BUNDLE_EXTENSION);
            ResourceBundle bundle = null;
            InputStream stream = null;
            if (reload) {
                URL url = loader.getResource(resourceName);
                if (url != null) {
                    URLConnection connection = url.openConnection();
                    if (connection != null) {
                        connection.setUseCaches(false);
                        stream = connection.getInputStream();
                    }
                }
            } else {
                stream = loader.getResourceAsStream(resourceName);
            }
            if (stream != null) {
                try {
                    bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
                } finally {
                    stream.close();
                }
            }
            return bundle;
        }

        @Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            return locale == Locale.ROOT ? null : Locale.ROOT;
        }
        
        
    }
}