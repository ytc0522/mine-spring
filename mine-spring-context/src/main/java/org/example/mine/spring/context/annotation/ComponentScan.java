package org.example.mine.spring.context.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者 xinyi
 * 日期 2022/5/2 8:08 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentScan {

    String[] value() default {};

    String[] basePackages() default {};

}
