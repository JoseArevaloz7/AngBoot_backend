package com.jg.book.book;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.jg.book.user.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMaper bookMaper;

    public Integer save(BookRequest request, Authentication authentication) {
        User user = ((User) authentication.getPrincipal());
        Book book = bookMaper.toBook(request);

        book.setOwner(user);

        return bookRepository.save(book).getId();
    }

    public BookResponse findById(Integer bookId) {
        return bookMaper.toBookResponse(bookRepository.findById(bookId).get());
    }
}