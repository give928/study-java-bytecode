package com.give928.java.bytecode.reflection.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    public static final String NAME = "KIM JOOHO";
    private String name = "jooho kim";

    private void print() {
        System.out.println("print!!");
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
