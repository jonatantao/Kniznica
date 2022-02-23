package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books;

    public BookService(){
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

    public List<Book> getBooks(String bookAuthor){
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

    public Book getBook(int bookId){
        return this.books.get(bookId);
    }

    public List<Book> getBookId(String bookId){
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

    public List<Book> getBookIsbn(String bookIsbn){
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

    public List<Book> createBook(Book book){
        this.books.add(book);
        return books;
    }

    public void deleteBook(int bookId){
        this.books.remove(this.books.get(bookId));
    }

    public List<Book> putBook(int bookId, Book book){
        this.books.get(bookId).setId(book.getId());
        this.books.get(bookId).setAuthor(book.getAuthor());
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setIsbn(book.getIsbn());
        return books;
    }
}
