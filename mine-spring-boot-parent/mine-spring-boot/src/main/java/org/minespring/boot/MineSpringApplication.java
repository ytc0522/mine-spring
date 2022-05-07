package org.minespring.boot;

import org.example.mine.spring.context.ConfigurableApplicationContext;

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


        return context;
    }


}
