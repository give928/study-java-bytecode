package com.give928.java.bytecode.reflection.domain;

import com.give928.java.bytecode.reflection.annotation.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@MyAnnotation("jooho")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private static String privateStaticStringVar = "BOOK";
    private static final String privateStaticFinalStringVar = "BOOK";

    private String privateStringVar = "private string var";
    @MyAnnotation("public field!!")
    public String publicStringVar = "public string var";
    protected String protectedStringVar = "protected string var";

    private void privateVoidFunction() {
        System.out.println("private void function");
    }

    public void publicVoidFunction() {
        System.out.println("public void function");
    }

    @MyAnnotation("public int method!!")
    public int publicIntFunction() {
        System.out.println("public int function");
        return 100;
    }
}
