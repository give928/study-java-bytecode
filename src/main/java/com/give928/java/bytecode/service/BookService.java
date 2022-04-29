package com.give928.java.bytecode.service;

import com.give928.java.bytecode.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {
    final BookRepository bookRepository;
}
