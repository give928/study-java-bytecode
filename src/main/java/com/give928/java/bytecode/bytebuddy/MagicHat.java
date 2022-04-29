package com.give928.java.bytecode.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MagicHat {
    private static final String CLASSES_PATH = "/Users/joohokim/Development/workspace/study/java/study-java-bytecode/out/production/classes";

    /**
     * changeBytecode 메서드로 바이트코드를 바꾸고 실행하면 소스코드와 다르게 바이트 코드가 바뀌어서 다른 내용이 출력된다.
     * 위의 코드가 실행되기 전에는 바이트코드가 바뀌지 않는다.
     *
     * agent 를 이용하면 클래스로더가 클래스를 읽어올 때 javaagent를 거쳐서 변경된 바이트코드를 읽어들여 메모리에 올려서 사용한다.
     * 처음 방식 처럼 클래스 자체를 바꾸지 않는다.
     * study-java-bytecode-magicagent 를 빌드해서 vm 옵션에 -javaagent:study-java-bytecode-magicagent-1.0-SNAPSHOT.jar
     */
    public static void main(String[] args) {
//        changeBytecodeByClass();
//        changeBytecodeByClassPath();

        System.out.println("new Hat().pullOut() = " + new Hat().pullOut());
    }

    private static void changeBytecodeByClass() {
        try {
            new ByteBuddy().redefine(Hat.class)
                    .method(named("pullOut"))
                    .intercept(FixedValue.value("Rabbit!!"))
                    .make()
                    .saveIn(new File(CLASSES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void changeBytecodeByClassPath() {
        ClassLoader classLoader = MagicHat.class.getClassLoader();
        TypePool typePool = TypePool.Default.of(classLoader);
        try {
            new ByteBuddy().redefine(typePool.describe("com.give928.java.bytecode.bytebuddy.Hat").resolve(), ClassFileLocator.ForClassLoader.of(classLoader))
                    .method(named("pullOut"))
                    .intercept(FixedValue.value("Rabbit!!!"))
                    .make().saveIn(new File(CLASSES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
