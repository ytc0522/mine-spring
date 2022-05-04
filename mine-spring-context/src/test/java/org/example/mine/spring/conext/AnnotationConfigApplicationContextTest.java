package org.example.mine.spring.conext;

import junit.framework.TestCase;

public class AnnotationConfigApplicationContextTest extends TestCase {

    public void testScan() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("");

    }
}