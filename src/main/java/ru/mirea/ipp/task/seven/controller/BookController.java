package ru.mirea.ipp.task.seven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.mirea.ipp.task.seven.entity.BookEntity;
import ru.mirea.ipp.task.seven.repository.BookRepository;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @QueryMapping
    public List<BookEntity> findAllBooks() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public List<BookEntity> findAllByAuthor(@Argument String author) {
        return bookRepository.findBookByAuthorName(author);
    }

    @MutationMapping
    public BookEntity createBook(@Argument BookInput bookInput) {
        BookEntity bookEntity = new BookEntity(bookInput.bookName, bookInput.genre, bookInput.authorName);
        return bookRepository.save(bookEntity);
    }

    record BookInput(String bookName, String genre, String authorName) {
    }
}
