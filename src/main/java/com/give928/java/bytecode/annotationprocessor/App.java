package com.give928.java.bytecode.annotationprocessor;

public class App {
    /**
     * study-java-bytecode-annotation-processor 에 의해서 @Magic 인터페이스들의 구현 클래스가 생성된다.
     * generated 경로를 소스 패스에 추가해준다.
     */
    public static void main(String[] args) {
        Hat Hat = new MagicHat();
        System.out.println(Hat.pullOut());
    }
}
