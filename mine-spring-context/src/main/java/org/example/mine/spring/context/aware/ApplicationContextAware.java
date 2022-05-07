package org.example.mine.spring.context.aware;

import org.example.mine.spring.beans.aware.Aware;
import org.example.mine.spring.context.ApplicationContext;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext);

}
