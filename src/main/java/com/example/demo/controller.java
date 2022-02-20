package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {
    List<Book> books;
    public controller(){
        this.books = init();
    }

    public List<Book> init() {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setAuthor("Haruki Murakami");
        book1.setTitle("Norwegian Wood");
        book1.setIsbn("0099448823");
        book1.setId("1");
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthor("Conan");
        book2.setTitle("Cau");
        book2.setIsbn("456");
        book2.setId("2");
        books.add(book2);

        return books;
    }
    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAuthor){
        if (bookAuthor == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getAuthor().equals(bookAuthor)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @GetMapping("/api/book/{bookId}")
    public Book getBook(@PathVariable Integer bookId){
        return this.books.get(bookId);
    }

    @GetMapping("/api/id")
    public List<Book> getBookId(@RequestParam(required = false) String bookId){
        if (bookId == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getId().equals(bookId)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @GetMapping("/api/isbn")
    public List<Book> getBookIsbn(@RequestParam(required = false) String bookIsbn){
        if (bookIsbn == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getIsbn().equals(bookIsbn)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @PostMapping("/api/books")
    public List<Book> createBook(@RequestBody Book book){
        this.books.add(book);

        return books;
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));
    }

    @PutMapping("/api/books")
    public void putBook(@PathVariable Integer bookId, @RequestBody Book book){
        this.books.get(bookId).setId(book.getId());
        this.books.get(bookId).setAuthor(book.getAuthor());
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setIsbn(book.getIsbn());
    }

}
