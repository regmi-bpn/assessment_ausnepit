package com.assignment.one.book.service.impl;

import com.assignment.one.book.constants.StatusEnum;
import com.assignment.one.book.dal.BookEntity;
import com.assignment.one.book.dal.BookRepository;
import com.assignment.one.book.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookEntity> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<BookEntity> findBookByStatus(StatusEnum status) {
        return bookRepository.findByStatus(status);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book with id:" + id + " not found."));
        bookRepository.deleteById(id);
    }

    @Override
    public BookEntity saveBook(BookEntity book) {
        return bookRepository.save(book);
    }

    @Override
    public BookEntity updateBook(Integer id, BookEntity book) {
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book with id:" + id + " not found."));
        book.setId(id);
        return bookRepository.save(book);
    }

    @Override
    public BookEntity updateStatus(Integer id, StatusEnum status) {
        BookEntity book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book with id:" + id + " not found."));
        book.setStatus(status);
        return bookRepository.save(book);
    }
}
