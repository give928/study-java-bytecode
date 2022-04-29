package com.give928.java.bytecode.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ContentServiceTest {
//    ContentService contentService // 서브젝트 타입
//            = new ContentServiceProxy( // 프록시
//                    new ContentServiceImpl() // 리얼 서브젝트
//    );
    ContentService contentService = (ContentService) Proxy.newProxyInstance(
        ContentService.class.getClassLoader(),
        new Class[]{ContentService.class},
        new InvocationHandler() {
            ContentService contentService = new ContentServiceImpl();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("시작");
                    Object invoke = method.invoke(contentService, args);
                    System.out.println("종료");
                    return invoke;
                }

                return method.invoke(contentService, args);
            }
        });

    @Test
    void rent() {
        Content content1 = Content.builder().title("content1").build();
        contentService.rent(content1);
        contentService.returnContent(content1);
    }
}
