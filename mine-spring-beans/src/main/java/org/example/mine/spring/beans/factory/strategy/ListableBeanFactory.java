package org.example.mine.spring.beans.factory.strategy;

import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.beans.factory.BeanFactory;

import java.util.Map;

/**
 *
 */
public interface ListableBeanFactory extends BeanFactory {


    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException;


}
