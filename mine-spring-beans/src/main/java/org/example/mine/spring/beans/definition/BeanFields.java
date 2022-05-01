package org.example.mine.spring.beans.definition;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Data
public class BeanFields implements Iterable<BeanField> {

    private List<BeanField> beanFields;

    @Override
    public Iterator<BeanField> iterator() {
        return getBeanFields().iterator();
    }

    public void addBeanField(BeanField... beanField) {
        if (beanFields == null) {
            beanFields = new ArrayList<>();
        }

        beanFields.addAll(Arrays.asList(beanField));
    }


}
