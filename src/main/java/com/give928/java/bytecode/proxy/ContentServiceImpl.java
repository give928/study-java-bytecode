package com.give928.java.bytecode.proxy;

public class ContentServiceImpl implements ContentService {
    @Override
    public void rent(Content content) {
        System.out.println("rent: " + content.getTitle());
    }

    @Override
    public void returnContent(Content content) {
        System.out.println("returnContent: " + content.getTitle());
    }
}
