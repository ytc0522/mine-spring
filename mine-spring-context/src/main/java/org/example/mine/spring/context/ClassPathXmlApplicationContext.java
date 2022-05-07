package org.example.mine.spring.context;

/**
 * 作者 xinyi
 * 日期 2022/5/2 12:25 PM
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {

    }

    /**
     * 从XML中加载BeanDefinition,并且刷新上下文
     */
    public ClassPathXmlApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocation() {
        return configLocations;
    }

}
