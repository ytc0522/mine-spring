package org.example.mine.spring.beans.definition;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BeanField {

    private String name;

    private Object value;

}
