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
        book1.setAuthor("Arthur");
        book1.setTitle("Study in Red");
        book1.setIsbn(123);
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthor("Conan");
        book2.setTitle("Cau");
        book2.setIsbn(456);
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

    @GetMapping("/api/book/{bookIsbn}")
    public Book getBookIsbn(@PathVariable Integer bookIsbn){
        return this.books.get(bookIsbn);
    }

    @PostMapping("/api/books")
    public Integer createBook(@RequestBody Book book){
        this.books.add(book);

        return this.books.size();
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));
    }

    @PutMapping("/api/books")
    public void putBook(@PathVariable Integer bookId, @PathVariable Integer bookIsbn, @RequestBody Book book){
        this.books.get(bookId).setAuthor(book.getAuthor());
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookIsbn).setIsbn(book.getIsbn());
    }

}
