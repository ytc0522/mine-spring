package org.example.mine.spring.conext.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.example.mine.spring.beans.definition.BeanDefinition;
import org.example.mine.spring.beans.definition.BeanDefinitionHolder;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 作者 xinyi
 * 日期 2022/5/4 10:39 AM
 */
@Slf4j
public class BeanDefinitionScanner {

    public Set<BeanDefinitionHolder> scan(String... basePackages) {
        Set<BeanDefinitionHolder> set = new HashSet<>();
        for (String basePackage : basePackages) {

            if (log.isDebugEnabled()) {
                log.debug("正在扫描包路径:{}", basePackage);
            }

            ClassUtil.scanPackage(basePackage, clazz -> {

                Annotation[] annotations = clazz.getDeclaredAnnotations();
                BeanDefinitionHolder definitionHolder = null;
                for (Annotation annotation : annotations) {
                    if (isBeanAnno(annotation)) {
                        String beanName = getBeanName(annotation, clazz);
                        BeanDefinition beanDefinition = new BeanDefinition(clazz, null);
                        definitionHolder = new BeanDefinitionHolder(beanName, beanDefinition);
                    }
                }
                if (definitionHolder != null) {
                    set.add(definitionHolder);
                }
                return definitionHolder != null;
            });
        }
        return set;
    }


    private boolean isBeanAnno(Annotation annotation) {
        return annotation instanceof Component
                || annotation instanceof Service
                || annotation instanceof Controller;
    }


    private String getBeanName(Annotation beanAnno, Class beanClass) {
        String beanName = null;
        if (beanAnno instanceof Component) {
            beanName = ((Component) beanAnno).value();
        } else if (beanAnno instanceof Service) {
            beanName = ((Service) beanAnno).value();
        } else if (beanAnno instanceof Controller) {
            beanName = ((Controller) beanAnno).value();
        }
        if (StrUtil.isEmpty(beanName)) {
            beanName = beanClass.getSimpleName();
        }
        beanName = StrUtil.lowerFirst(beanName);
        return beanName;
    }


}
