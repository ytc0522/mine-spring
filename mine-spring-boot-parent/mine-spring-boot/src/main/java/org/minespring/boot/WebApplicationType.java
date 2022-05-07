package org.minespring.boot;

import org.example.mine.spring.beans.util.ClassUtils;

/**
 * WEB应用的种类
 */
public enum WebApplicationType {

    NONE,

    SERVLET,

    //REACTIVE
    ;

    private static final String[] SERVLET_INDICATOR_CLASSES = {"javax.servlet.Servlet",
            "org.example.mine.spring.context.ConfigurableApplicationContext"};


    public static WebApplicationType deduceFromClassPath() {
        for (String className : SERVLET_INDICATOR_CLASSES) {
            if (!ClassUtils.isPresent(className)) {
                return WebApplicationType.NONE;
            }
        }
        return WebApplicationType.SERVLET;
    }
}
