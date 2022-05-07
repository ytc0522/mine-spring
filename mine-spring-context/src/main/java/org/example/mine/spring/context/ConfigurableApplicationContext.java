package org.example.mine.spring.context;

import org.example.mine.spring.beans.exceptions.BeanException;

public interface ConfigurableApplicationContext extends ApplicationContext {


    void refresh() throws BeanException;


}
