package org.example.mine.spring.conext;

import org.example.mine.spring.beans.exceptions.BeanException;

public interface ConfigurableApplicationContext extends ApplicationContext {


    void refresh() throws BeanException;


}
