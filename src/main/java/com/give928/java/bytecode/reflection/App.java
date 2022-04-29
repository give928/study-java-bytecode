package com.give928.java.bytecode.reflection;

import com.give928.java.bytecode.reflection.annotation.MyAnnotation;
import com.give928.java.bytecode.reflection.domain.Book;
import com.give928.java.bytecode.reflection.domain.MyBook;
import com.give928.java.bytecode.reflection.domain.Student;

import java.lang.reflect.*;
import java.util.Arrays;

public class App {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        testReflection();

        Class<?> studentClass = Class.forName("com.give928.java.bytecode.reflection.domain.Student");
        Constructor<?> constructor = studentClass.getConstructor(String.class);
        Student student = (Student) constructor.newInstance("jooho");
        System.out.println("student = " + student);

        // 필드
        Field staticName = Student.class.getDeclaredField("NAME");
        System.out.println("staticName.get(null) = " + staticName.get(null));

        staticName.set(null, "KJH");
        System.out.println("staticName.get(null) = " + staticName.get(null));

        Field name = Student.class.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println("name.get(student) = " + name.get(student));

        name.set(student, "JOOHO");
        System.out.println("name.get(student) = " + name.get(student));

        // 메서드
        System.out.println();
        Method print = Student.class.getDeclaredMethod("print");
        print.setAccessible(true);
        print.invoke(student);

        Method sum = Student.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(student, 1, 2);
        System.out.println("invoke = " + invoke);
    }

    private static void testReflection() throws ClassNotFoundException {
        Class<Book> bookClass = Book.class; // 타입으로

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass(); // 인스턴스로

        Class<?> bClass = Class.forName("com.give928.java.bytecode.reflection.domain.Book");

        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        System.out.println();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(field -> {
            Arrays.stream(field.getAnnotations()).forEach(annotation -> {
                if (annotation instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println(myAnnotation);
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.number());
                }
            });
            try {
                field.setAccessible(true);
                System.out.printf("%s === %s\n", field, field.get(book));
                int modifiers = field.getModifiers();
                System.out.println("Modifier.isPrivate(modifiers) = " + Modifier.isPrivate(modifiers));
                System.out.println("Modifier.isStatic(modifiers) = " + Modifier.isStatic(modifiers));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println();
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        System.out.println();
        Arrays.stream(bookClass.getMethods()).forEach(method -> {
            System.out.println("method = " + method);
            System.out.println("method.getParameterCount() = " + method.getParameterCount());
            System.out.println("method.getParameterTypes() = " + method.getParameterTypes());
            System.out.println("method.getReturnType() = " + method.getReturnType());
            int modifiers = method.getModifiers();
            System.out.println("Modifier.isPrivate(modifiers) = " + Modifier.isPrivate(modifiers));
            System.out.println("Modifier.isStatic(modifiers) = " + Modifier.isStatic(modifiers));

            Arrays.stream(method.getAnnotations()).forEach(annotation -> {
                if (annotation instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println(myAnnotation);
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.number());
                }
            });
        });

        System.out.println();
        Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        System.out.println("superclass = " + superclass);

        System.out.println();
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        System.out.println();
        System.out.println();

        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);

        System.out.println();
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        System.out.println();
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);
    }
}
