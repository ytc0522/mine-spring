package org.minespring.boot;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.beans.io.SpringFactoriesLoader;
import org.example.mine.spring.context.ConfigurableApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 作者 xinyi
 * 日期 2022/5/7
 */
@Slf4j
public class MineSpringApplication {

    @Getter
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

        // 加载spring.factories 并实例化
        SpringFactoriesLoader.loadFactories();

        // 准备刷新Context
        prepareContext(context);

        // 刷新Context
        refreshContext(context);

        return context;
    }

    private void prepareContext(ConfigurableApplicationContext context) {
        Set<Class<?>> primarySources = getPrimarySources();


    }


    private void refreshContext(ConfigurableApplicationContext context) {
        context.refresh();
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

    /**
     * @param type           要实例化的类型
     * @param parameterTypes 构造方法的参数类型
     * @param args           构造方法的参数
     * @param names          具体的要实例化的全类名
     */
    private void createSpringFactoriesInstances(Class<?> type, Class<?>[] parameterTypes, Object[] args, Set<String> names) {

    }


}
