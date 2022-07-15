package com.assignment.one.book.service;

import com.assignment.one.book.constants.StatusEnum;
import com.assignment.one.book.dal.BookEntity;

import java.util.List;

public interface IBookService {
    List<BookEntity> findAllBooks();

    List<BookEntity> findBookByStatus(StatusEnum status);

    BookEntity saveBook(BookEntity book);

    BookEntity updateBook(Integer id, BookEntity book);

    BookEntity updateStatus(Integer id, StatusEnum status);

    void deleteById(Integer id);

}
