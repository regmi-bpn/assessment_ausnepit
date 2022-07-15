package com.assignment.one.book.rest;

import com.assignment.one.book.constants.StatusEnum;
import com.assignment.one.book.dal.BookEntity;
import com.assignment.one.book.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookEntity> getAllBook() {
        return bookService.findAllBooks();
    }

    @GetMapping("/active")
    public List<BookEntity> getActiveBooks() {
        return bookService.findBookByStatus(StatusEnum.ACTIVE);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity saveBook(@RequestBody BookEntity book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(@PathVariable("id") Integer id, @RequestBody BookEntity book) {
        return bookService.updateBook(id, book);
    }

    @PatchMapping("/{id}/{status}")
    public BookEntity updateStatus(@PathVariable("id") Integer id,@PathVariable("status") StatusEnum status) {
        return bookService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }
}
