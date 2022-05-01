package org.example.mine.spring.beans.io;

import cn.hutool.core.lang.Assert;
import lombok.SneakyThrows;
import org.example.mine.spring.beans.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 作者 xinyi
 * 日期 2022/5/1 10:33 PM
 */
public class ClassPathResource implements Resource {

    private final String path;

    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    @SneakyThrows
    public InputStream getInputStream() {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return inputStream;
    }
}
