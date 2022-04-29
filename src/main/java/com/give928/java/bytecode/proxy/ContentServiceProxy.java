package com.give928.java.bytecode.proxy;

public class ContentServiceProxy implements ContentService {
    ContentService contentService;

    public ContentServiceProxy(ContentService contentService) {
        this.contentService = contentService;
    }

    @Override
    public void rent(Content content) {
        System.out.println("로깅 시작");
        contentService.rent(content);
        System.out.println("로깅 종료");
    }

    @Override
    public void returnContent(Content content) {
        contentService.returnContent(content);
    }
}
