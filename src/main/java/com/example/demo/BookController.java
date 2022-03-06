package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<BookDto> getBooks(@RequestParam(required = false) String bookAuthor){
        return bookService.getBooks(bookAuthor);
    }

    @GetMapping("/api/book/{bookId}") //search by {bookId}
    public BookDto getBook(@PathVariable Long bookId){
        return this.bookService.getBook(bookId);
    }

    @GetMapping("/api/id") //search by bookId
    public List<BookDto> getBookId(@RequestParam(required = false) String bookId){
        return bookService.getBookId(bookId);
    }

    @GetMapping("/api/isbn") //search by bookIsbn
    public List<BookDto> getBookIsbn(@RequestParam(required = false) String bookIsbn){
        return bookService.getBookIsbn(bookIsbn);
    }

    @PostMapping("/api/books") //create new book
    public Long createBook(@RequestBody BookDto bookDto){
        return bookService.createBook(bookDto);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable int bookId){
        bookService.deleteBook(bookId);
    }

    @PutMapping("/api/books/{bookId}") //update by {book}
    public void putBook(@PathVariable int bookId, @RequestBody BookDto bookDto){
        bookService.putBook(bookId, bookDto);
    }
}
