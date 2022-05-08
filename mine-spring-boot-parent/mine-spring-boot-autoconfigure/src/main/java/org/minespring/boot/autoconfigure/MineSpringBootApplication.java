package org.minespring.boot.autoconfigure;

import org.example.mine.spring.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ComponentScan
public @interface MineSpringBootApplication {


}
