package com.jg.book.book;

import org.springframework.stereotype.Service;

@Service
public class BookMaper {
    
    public Book toBook(BookRequest request) {
        return Book.builder()
            .id(request.id())
            .title(request.title())
            .authorName(request.authName())
            .synopsis(request.synopsis())
            .archived(false)
            .shareable(request.shareable())
            .build();
    }
}  
