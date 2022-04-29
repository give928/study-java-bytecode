package com.give928.java.bytecode.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ContentRepositoryTest {
    @Autowired
    ContentRepository contentRepository;

    @Test
    void di() {
        assertNotNull(contentRepository);
    }

    @Test
    void save() {
        Content content = Content.builder().title("content1").build();
        Content saved = contentRepository.save(content);
        assertNotNull(saved);

        List<Content> contents = contentRepository.findAll();
        assertNotNull(contents);
    }
}
