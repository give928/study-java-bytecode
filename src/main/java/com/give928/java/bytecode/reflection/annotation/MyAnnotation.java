package com.give928.java.bytecode.reflection.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Inherited
public @interface MyAnnotation {
    String value();
    int number() default 100;
}
