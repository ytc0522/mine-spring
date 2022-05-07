package org.minespring.boot;

import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.context.ConfigurableApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 作者 xinyi
 * 日期 2022/5/7
 */
public class MineSpringApplication {

    private final Set<Class<?>> primarySources;

    private final WebApplicationType webApplicationType;

    /**
     * WEB应用使用的的ApplicationContext类名称
     */
    public static final String DEFAULT_SERVLET_WEB_CONTEXT_CLASS = "";
    /**
     * 非WEB应用使用的的ApplicationContext类名称
     */
    public static final String DEFAULT_CONTEXT_CLASS = "";
    private Class<? extends ConfigurableApplicationContext> applicationContextClass;


    public MineSpringApplication(Class<?>... primarySources) {
        this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
        this.webApplicationType = WebApplicationType.deduceFromClassPath();
    }


    /**
     * 方便启动应用的方法
     */
    public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        return run(new Class<?>[]{primarySource}, args);
    }

    private static ConfigurableApplicationContext run(Class<?>[] classes, String[] args) {
        return new MineSpringApplication(classes).run(args);
    }

    public ConfigurableApplicationContext run(String... args) {
        ConfigurableApplicationContext context = null;

        // 创建context
        context = createApplicationContext();


        return context;
    }

    protected ConfigurableApplicationContext createApplicationContext() {
        Class<?> contextClass = this.applicationContextClass;
        if (contextClass == null) {
            try {
                switch (this.webApplicationType) {
                    case SERVLET:
                        contextClass = Class.forName(DEFAULT_SERVLET_WEB_CONTEXT_CLASS);
                        break;
                    default:
                        contextClass = Class.forName(DEFAULT_CONTEXT_CLASS);
                }
            } catch (ClassNotFoundException ex) {
                throw new IllegalStateException(
                        "Unable create a default ApplicationContext, please specify an ApplicationContextClass", ex);
            }
        }
        try {
            return (ConfigurableApplicationContext) contextClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new BeanException("创建 ConfigurableApplicationContext 异常", e);
        }
    }


}
