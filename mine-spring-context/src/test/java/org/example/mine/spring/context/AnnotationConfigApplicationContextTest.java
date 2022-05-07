package org.example.mine.spring.context;

import junit.framework.TestCase;

public class AnnotationConfigApplicationContextTest extends TestCase {

    public void testScan() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("");

    }
}