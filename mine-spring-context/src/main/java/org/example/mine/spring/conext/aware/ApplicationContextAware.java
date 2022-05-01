package org.example.mine.spring.conext.aware;

import org.example.mine.spring.beans.aware.Aware;
import org.example.mine.spring.conext.ApplicationContext;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext);

}
