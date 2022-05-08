package org.example.mine.spring.beans.io;

import cn.hutool.core.util.StrUtil;
import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.beans.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 作者 xinyi
 * 日期 2022/5/8
 */
public final class SpringFactoriesLoader {


    public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories";

    private static final Map<String, Set<String>> factoriesMap = new ConcurrentHashMap<>();


    public static Set<String> getFactoryNames(Class<?> factoryType) {
        String factoryTypeName = factoryType.getName();
        Set<String> result = factoriesMap.get(factoryTypeName);
        if (result != null) {
            return result;
        }
        loadFactories();
        return factoriesMap.getOrDefault(factoryTypeName, Collections.emptySet());
    }


    public static void loadFactories() {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();

        try {
            Enumeration<URL> urls =
                    classLoader.getResources(FACTORIES_RESOURCE_LOCATION);

            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                Properties properties = getPropertiesFromUrl(url);

                Set<Map.Entry<Object, Object>> entries = properties.entrySet();

                for (Map.Entry<?, ?> entry : entries) {
                    String factoryClassName = ((String) entry.getKey()).trim();
                    List<String> factoryImplClassNames = StrUtil.split((String) entry.getValue(), ',');

                    for (String factoryImplClassName : factoryImplClassNames) {
                        Set<String> implClassNameSet = factoriesMap.get(factoryClassName);
                        if (implClassNameSet == null) {
                            implClassNameSet = new LinkedHashSet<>();
                        }
                        implClassNameSet.add(factoryImplClassName);
                    }
                }
            }
        } catch (IOException e) {
            throw new BeanException("Unable to load factories from location [" +
                    FACTORIES_RESOURCE_LOCATION + "]", e);
        }


    }


    private static Properties getPropertiesFromUrl(URL url) throws IOException {
        InputStream is = url.openConnection().getInputStream();
        Properties properties = new Properties();
        properties.load(is);
        return properties;
    }


}
