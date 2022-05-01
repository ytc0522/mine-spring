package org.example.mine.spring.beans.io;


import cn.hutool.core.lang.Assert;
import org.example.mine.spring.beans.exceptions.BeanException;

/**
 * 作者 xinyi
 * 日期 2022/5/1 10:45 PM
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        throw new BeanException("暂时不支持这种方式加载");
    }
}
