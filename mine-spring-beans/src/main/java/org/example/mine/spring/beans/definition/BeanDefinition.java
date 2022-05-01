package org.example.mine.spring.beans.definition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeanDefinition {

    private Class<?> beanClass;

    private  BeanFields beanFields;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }


}
